package ast;

import java.util.ArrayList;
import java.util.HashMap;
import util.Environment;
import util.SemanticError;

public class ProgramNode implements Node{
	private final ArrayList<DeclarationNode> declarations;
	private final ArrayList<StatementNode> statements;
	private Environment internalEnv;
	
	public ProgramNode(ArrayList<DeclarationNode> declarations, ArrayList<StatementNode> statements) {
		this.declarations = declarations;
		this.statements = statements;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		String declstr = "";
		String statstr = "";
		for(DeclarationNode dec: declarations)
			declstr += dec.toPrint(indent,internalEnv);
		for(StatementNode stat: statements)
			statstr += stat.toPrint(indent,internalEnv);
		return "Main program\n" +  declstr + statstr + "\n";
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		ArrayList<Environment> environmentsInternal = new ArrayList<>();
		for(DeclarationNode dec: declarations) {
			if(!thread.isInterrupted()){
				dec.typeCheck(internalEnv);
				if(!thread.isInterrupted()){
					if(dec.getDeclaration().getClass().getName().contains("DecFunNode")){
						DecFunNode function = (DecFunNode) (dec.getDeclaration());
						environmentsInternal.add(function.getBlock().getInternalEnv());
					}
				}
			}
		}
		for(StatementNode stat: statements) {
			if(!thread.isInterrupted()){
				stat.typeCheck(internalEnv);
				if(!thread.isInterrupted()){
					if(stat.getStatement().getClass().getName().contains("IteNode")){
						IteNode ifThenElse = (IteNode)(stat.getStatement());
						StatementNode statementThen = ifThenElse.getThenStatement();
						StatementNode statementElse = ifThenElse.getElseStatement();
						if(statementThen.getStatement().getClass().getName().contains("BlockNode")){
							BlockNode blockThen = (BlockNode)(statementThen.getStatement());
							environmentsInternal.add(blockThen.getInternalEnv());
						}
						if(statementElse != null){
							if(statementElse.getStatement().getClass().getName().contains("BlockNode")){
								BlockNode blockElse = (BlockNode)(statementElse.getStatement());
								environmentsInternal.add(blockElse.getInternalEnv());
							}
						}
					}
					if(stat.getStatement().getClass().getName().contains("BlockNode")){
						BlockNode blockStatement = (BlockNode)(stat.getStatement());
						environmentsInternal.add(blockStatement.getInternalEnv());
					}
				}
			}
		}
		if(!thread.isInterrupted()){
			if(environmentsInternal.size() > 0){
				for(int i=internalEnv.getNestingLevel();i >= 0 ;i--){
					HashMap<String,STentry> hm1 = internalEnv.getSymTableManagement().getLevel(i);
					for(Environment environment:environmentsInternal){
						for(int j=environment.getNestingLevel();j >= 0 ;j--){
							HashMap<String,STentry> hm2 = environment.getSymTableManagement().getLevel(j);
							for(String id1 :hm1.keySet()){
								for(String id2:hm2.keySet()){
									if(id1.equals(id2) && hm1.get(id1).getNestinglevel() == hm2.get(id2).getNestinglevel()){
										if(hm2.get(id2).getEffect().isUsed()){
											hm1.get(id1).getEffect().setUsed();
										}
									}
								}
							}
						}
					}
				}
			}
			HashMap<String,STentry> hm = internalEnv.getSymTableManagement().getLevel(internalEnv.getNestingLevel());
			for(String id: hm.keySet()){
				if(!thread.isInterrupted()){
					if(!hm.get(id).getEffect().isUsed()){
						System.err.println("The symbol "+id+" isn't used in the program.");
						thread.interrupt();
					}
				}
			}
		}
		return null;
	}

	@Override
	public String codeGeneration(Environment env) {
		int memorySpace = internalEnv.getSymTableManagement().computeMemorySpace(internalEnv.getNestingLevel());
		String codeFunctions = "";
		String code = ";PROGRAM_NODE\n";
		if(declarations.size() > 0) {
			code += "push $fp\n";
			code += ((memorySpace > 0) ? "addi $sp $sp -" + memorySpace + "\n" : "");
			for (DeclarationNode dec: declarations) {
				if(dec.getDeclaration().getClass().getName().contains("DecVarNode")) {
					code += dec.codeGeneration(internalEnv);

				} else {
					codeFunctions += dec.codeGeneration(internalEnv);
				}
			}
		} else {
			code += "push $fp\n";
		}
		for (StatementNode stat : statements) {
			code += stat.codeGeneration(internalEnv);
		}
		if(declarations.size()>0 ) {
			for(DeclarationNode dec : declarations) {
				if(dec.getDeclaration().getClass().getName().contains("DecVarNode")) {
					DecVarNode var = (DecVarNode) dec.getDeclaration();
					int offset = internalEnv.getSymTableManagement().getEntryId(var.getIdNode().getId(), internalEnv.getNestingLevel()).getOffset();
					//code += "move $al $fp\n";
					code += "li $a0 0\n";
					code += "sw $a0 " + offset +"($fp)\n";
				}
			}
			code += "lw $fp 0($fp)\n";
			code += ((memorySpace > 0) ? "addi $sp $sp " + memorySpace + "\n" : "");
		} else {
			code += "lw $fp 0($fp)\n";
		}
		code += "pop\n";
		//code += "halt\n";
		code += codeFunctions;
		
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		env.incrementNestingLevel();
		HashMap<String,STentry> hm = new HashMap<>();
		env.getSymTableManagement().addLevel(hm);
		ArrayList<SemanticError> output = new ArrayList<>();
		if(declarations.size() > 0) {
			env.setOffsetVariabili(0);
			for(DeclarationNode dec:declarations) {
				output.addAll(dec.checkSemantics(env));
			}
		}
		if(statements.size() > 0) {
			env.setOffsetVariabili(0);
			int cont = 0;
			for(StatementNode stat:statements) {
				output.addAll(stat.checkSemantics(env));
				if(stat.getStatement().getClass().getName().contains("RetNode")){
					cont++;
				}else{
					if(stat.getStatement().getClass().getName().contains("BlockNode")){
						BlockNode blockInternal = (BlockNode)(stat.getStatement());
						ArrayList<StatementNode> statementNodes = blockInternal.getStatements();
						for(StatementNode stat1:statementNodes){
							if(stat1.getStatement().getClass().getName().contains("RetNode")){
								cont++;
							}
						}
					}
					if(stat.getStatement().getClass().getName().contains("IteNode")){
						IteNode ifthenelse = (IteNode)(stat.getStatement());
						StatementNode thenStatement = ifthenelse.getThenStatement();
						StatementNode elseStatement = ifthenelse.getElseStatement();
						if(thenStatement.getStatement().getClass().getName().contains("RetNode")){
							cont++;
						}
						if(thenStatement.getStatement().getClass().getName().contains("BlockNode")){
							BlockNode blockInternalIte = (BlockNode)(thenStatement.getStatement());
							ArrayList<StatementNode> statementNodes = blockInternalIte.getStatements();
							for(StatementNode stat1:statementNodes){
								if(stat1.getStatement().getClass().getName().contains("RetNode")){
									cont++;
								}
							}
						}
						if(elseStatement != null){
							if(elseStatement.getStatement().getClass().getName().contains("RetNode")){
								cont++;
							}
							if(elseStatement.getStatement().getClass().getName().contains("BlockNode")){
								BlockNode blockInternalIte = (BlockNode)(elseStatement.getStatement());
								ArrayList<StatementNode> statementNodes = blockInternalIte.getStatements();
								for(StatementNode stat1:statementNodes){
									if(stat1.getStatement().getClass().getName().contains("RetNode")){
										cont++;
									}
								}
							}
						}
					}
				}
			}
			if(cont > 0){
				output.add(new SemanticError("The return statement can only be used within blocks of functions."));
			}
		}
		internalEnv=new Environment(env);
		env.getSymTableManagement().removeLevel(env.getNestingLevel());
		env.decrementNestingLevel();
		return output;
	}
}