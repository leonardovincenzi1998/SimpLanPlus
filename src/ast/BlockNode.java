package ast;

import java.util.ArrayList;
import java.util.HashMap;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusLib;

public class BlockNode implements Node {
	private final ArrayList<DecVarNode> declarations;
	private final ArrayList<StatementNode> statements;
	private Environment internalEnv;

	public BlockNode(ArrayList<DecVarNode> declarations,ArrayList<StatementNode> statements) {
		this.declarations = declarations;
		this.statements = statements;
	}

	@Override
	public String toPrint(String indent,Environment env){
		String declstr = "";
		String statstr = "";
		for(DecVarNode dec: declarations){
			for(int i = 0;i <= internalEnv.getNestingLevel();i++){
				declstr += indent + indent;
			}
			declstr += indent + dec.toPrint(indent,internalEnv) + "\n";
		}
		for(StatementNode stat: statements){
			for(int i = 0;i <= internalEnv.getNestingLevel();i++){
				statstr += indent + indent;
			}
			statstr += stat.toPrint(indent,internalEnv);
		}
		return "BlockNode\n" + declstr + statstr;
	}

	@Override
	public Node typeCheck(Environment env){
		Thread thread = Thread.currentThread();
		for(DecVarNode dec: declarations) {
			dec.typeCheck(internalEnv);
		}
		ArrayList<RetNode> retnodes = new ArrayList<>();
		int numberStat = 0;
		for(StatementNode stat: statements) {
			if(!thread.isInterrupted()){
				stat.typeCheck(internalEnv);
				//check if there are Return in the statements
				if(stat.getStatement().getClass().getName().contains("RetNode")) {
					RetNode statReturn = (RetNode)(stat.getStatement());
					retnodes.add(statReturn);
					if(numberStat != (statements.size()-1)){
						System.err.println("The return statement must be the last instruction of the block.");
						thread.interrupt();
					}
				}
				numberStat++;
			}
		}
		if(!thread.isInterrupted()) {
			if (retnodes.size() > 1) {
				System.err.println("In this block there are more return.");
				thread.interrupt();
			}
			if(!thread.isInterrupted()){
				ArrayList<TypeNode> returnTypes = new ArrayList<>();
				ArrayList<Environment> environmentsInternal = new ArrayList<>();
				for (StatementNode stat : statements) {
					if (stat.getStatement().getClass().getName().contains("IteNode")) {
						IteNode ifThenElse = (IteNode) (stat.getStatement());
						StatementNode statementThen = ifThenElse.getThenStatement();
						StatementNode statementElse = ifThenElse.getElseStatement();
						if (statementThen.getStatement().getClass().getName().contains("BlockNode")) {
							BlockNode blockThen = (BlockNode) (statementThen.getStatement());
							environmentsInternal.add(blockThen.getInternalEnv());
							ArrayList<StatementNode> listStatementsBlock = blockThen.getStatements();
							for (StatementNode stat1 : listStatementsBlock) {
								if (stat1.getStatement().getClass().getName().contains("RetNode")) {
									returnTypes.add((TypeNode) (stat1.typeCheck(blockThen.getInternalEnv())));
								}
							}
						}
						if (statementElse != null) {
							if (statementElse.getStatement().getClass().getName().contains("BlockNode")) {
								BlockNode blockElse = (BlockNode) (statementElse.getStatement());
								environmentsInternal.add(blockElse.getInternalEnv());
								ArrayList<StatementNode> listStatementsBlock = blockElse.getStatements();
								for (StatementNode stat1 : listStatementsBlock) {
									if (stat1.getStatement().getClass().getName().contains("RetNode")) {
										returnTypes.add((TypeNode) (stat1.typeCheck(blockElse.getInternalEnv())));
									}
								}
							}
						}
						if (statementThen.getStatement().getClass().getName().contains("RetNode")) {
							returnTypes.add((TypeNode) (statementThen.typeCheck(internalEnv)));
						}
						if (statementElse != null) {
							if (statementElse.getStatement().getClass().getName().contains("RetNode")) {
								returnTypes.add((TypeNode) (statementElse.typeCheck(internalEnv)));
							}
						}
					}
					if (stat.getStatement().getClass().getName().contains("BlockNode")) {
						BlockNode blockStatement = (BlockNode) (stat.getStatement());
						environmentsInternal.add(blockStatement.getInternalEnv());
						ArrayList<StatementNode> listStatementsBlock = blockStatement.getStatements();
						for (StatementNode stat1 : listStatementsBlock) {
							if (stat1.getStatement().getClass().getName().contains("RetNode")) {
								returnTypes.add((TypeNode) (stat1.typeCheck(blockStatement.getInternalEnv())));
							}
						}
					}
				}
				if (retnodes.size() == 1) {
					returnTypes.add((TypeNode) (retnodes.get(0).typeCheck(internalEnv)));
				}
				if (returnTypes.size() > 0) {
					int cont = 0;
					//control if the returns' type are equals
					for (TypeNode types : returnTypes) {
						for (TypeNode types1 : returnTypes) {
							if (!(SimpLanPlusLib.isSubtype(types, types1, internalEnv))) {
								cont++;
							}
						}
					}
					if (cont > 0) {
						System.err.println("There are different type of return in this block.");
						thread.interrupt();
					}
				}
				if(!thread.isInterrupted()){
					if (environmentsInternal.size() > 0) {
						for (int i = internalEnv.getNestingLevel(); i >= 0; i--) {
							HashMap<String, STentry> hm1 = internalEnv.getSymTableManagement().getLevel(i);
							for (Environment environment : environmentsInternal) {
								for (int j = environment.getNestingLevel(); j >= 0; j--) {
									HashMap<String, STentry> hm2 = environment.getSymTableManagement().getLevel(j);
									for (String id1 : hm1.keySet()) {
										for (String id2 : hm2.keySet()) {
											if (id1.equals(id2) && hm1.get(id1).getNestinglevel() == hm2.get(id2).getNestinglevel()) {
												if (hm2.get(id2).getEffect().isUsed()) {
													hm1.get(id1).getEffect().setUsed();
												}
											}
										}
									}
								}
							}

						}
					}
					HashMap<String, STentry> hm = internalEnv.getSymTableManagement().getLevel(internalEnv.getNestingLevel());
					for (String id : hm.keySet()) {
						if(!thread.isInterrupted()){
							if (!(hm.get(id).isAFunction())) {
								if (!hm.get(id).getEffect().isUsed()) {
									System.err.println("The variable " + id + " isn't used in this block.");
									thread.interrupt();
								}
							}
						}
					}
					if(!thread.isInterrupted()){
						if (returnTypes.size() > 0) {
							return returnTypes.get(0);
						}
						return new TypeNode("void");
					}
				}
				return new TypeNode("void");
			}
			return new TypeNode("void");
		}
		return new TypeNode("void");
	}

	@Override
	public String codeGeneration(Environment env){
		
		//System.out.println("nl block: " + env.getNestingLevel());
		
		
		int memorySpace = internalEnv.getSymTableManagement().computeMemorySpace(internalEnv.getNestingLevel());
		String code = ";BLOCK_NODE\n";
		if(declarations.size() > 0) {
			code += "push $fp\n";
			//code += "move $fp $sp\n";
			//code += ((memorySpace > 0) ? "addi $sp $sp -" + memorySpace + "\n" : "");
			for (DecVarNode dec: declarations) {
				code += dec.codeGeneration(internalEnv);
			}
		} else {
			code += "push $fp\n";
		//	code += "move $fp $sp\n";
		}
		for (StatementNode stat : statements) {
			code += stat.codeGeneration(internalEnv);
		}
		if(declarations.size()>0 ) {
			for(DecVarNode dec : declarations) {
					/*int offset = internalEnv.getSymTableManagement().getEntryId(dec.getIdNode().getId(), internalEnv.getNestingLevel()).getOffset();
					//code += "move $al $fp\n";
					code += "li $a0 0\n";
			//		code += "sw $a0 " + offset +"($al)\n";
					code += "sw $a0 " + offset +"($fp)\n";*/
				code += "pop\n";
			}

			code += "lw $fp 0($fp)\n";
		} else {
			code += "lw $fp 0($fp)\n";
		}
		code += "pop\n";
		//code += ((memorySpace > 0) ? "addi $sp $sp " + memorySpace + "\n" : "");

		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		env.incrementNestingLevel();
		
		//System.out.println("nl block: " + env.getNestingLevel());
		
		HashMap<String,STentry> hm = new HashMap<>();
		//env.getSymTableManagement().addLevel(hm);
		System.out.println("envBlockNode: " + env.getSymTableManagement().getSymbolTable());

		ArrayList<SemanticError> output = new ArrayList<>();
		int temp = env.getOffsetVariabili();
		if(declarations.size() > 0) {
			env.setOffsetVariabili(0);
			for(DecVarNode dec:declarations) {
				output.addAll(dec.checkSemantics(env));
			}
		}
		if(statements.size() > 0) {
			env.setOffsetVariabili(0);
			for(StatementNode stat:statements) {
				output.addAll(stat.checkSemantics(env));
			}
		}
		System.out.println("envBlockNode2: " + env.getSymTableManagement().getSymbolTable());

		internalEnv = new Environment(env);
		env.setOffsetVariabili(temp);
		env.getSymTableManagement().removeLevel(env.getNestingLevel());
		env.decrementNestingLevel();
		System.out.println("BlockEnv: " + env.getSymTableManagement().getSymbolTable());
		System.out.println("BlockInternalEnv " + internalEnv.getSymTableManagement().getSymbolTable());
		System.out.println("NestinLevel " + internalEnv.getNestingLevel());
		return output;
	}

	public ArrayList<StatementNode> getStatements() {
		return this.statements;
	}

	public ArrayList<DecVarNode> getDeclarations(){
		return this.declarations;
	}

	public Environment getInternalEnv(){
		return internalEnv;
	}

	
	
}