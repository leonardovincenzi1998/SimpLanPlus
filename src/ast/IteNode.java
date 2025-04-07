package ast;

import java.util.ArrayList;
import java.util.HashMap;
import ast.expNode.ExpNode;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusLib;

public class IteNode implements Node {
	private final ExpNode exp;
	private final StatementNode then_statement;
	private final StatementNode else_statement;

	public IteNode(ExpNode exp, StatementNode then_statement, StatementNode else_statement) {
		this.exp=exp;
		this.then_statement = then_statement;
		this.else_statement = else_statement;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		String stringa = "IteNode(";
		if(exp != null){
			stringa += exp.toPrint(indent,env);
		}
		stringa += ")\n";
		for(int i = 0;i <= env.getNestingLevel();i++){
			stringa += indent + indent;
		}
		stringa += "ThenStatement\n";
		for(int i = 0;i <= env.getNestingLevel();i++){
			stringa += indent + indent;
		}
		stringa += then_statement.toPrint(indent,env);
		if(else_statement != null){
			for(int i = 0;i <= env.getNestingLevel();i++){
				stringa += indent + indent;
			}
			stringa += "ElseStatement\n";
			for(int i = 0;i <= env.getNestingLevel();i++){
				stringa += indent + indent;
			}
			stringa += else_statement.toPrint(indent,env);
		}
		return stringa;
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		TypeNode typeExp = (TypeNode)(exp.typeCheck(env));
		if(!thread.isInterrupted()){
			if(!SimpLanPlusLib.isSubtype(typeExp, new TypeNode("bool"),env)) {
				System.err.println("The condition must return boolean value.");
				thread.interrupt();
			}
			if(!thread.isInterrupted()){
				Environment envCopy = new Environment(env);
				Node type_then = then_statement.typeCheck(env);
				if(!thread.isInterrupted()){
					if(else_statement != null) {
						Node type_else = else_statement.typeCheck(envCopy);
						if(!thread.isInterrupted()){
							if(type_then != null && type_else != null) {
								if(!SimpLanPlusLib.isSubtype(type_then,type_else,env) ) {
									System.err.println("The statements must have the same type.");
									thread.interrupt();
								}
							}
							if(!thread.isInterrupted()){
								for (int i = 0; i < env.getSymTableManagement().getSymbolTable().size(); i++) {
									HashMap<String, STentry> hm = env.getSymTableManagement().getSymbolTable().get(i);
									HashMap<String, STentry> hm1 = envCopy.getSymTableManagement().getSymbolTable().get(i);
									for (String key : hm.keySet()) {
										hm.get(key).getEffect().join(hm1.get(key).getEffect());
									}
								}
							}
						}
					}
				}
				return type_then;
			}
		}
		return new TypeNode("void");
	}

	@Override
	public String codeGeneration(Environment env) {
		String if_label = SimpLanPlusLib.newLabel("INSTRUCTIONS_IF");
		String end_label = SimpLanPlusLib.newLabel("END_IF_THEN_ELSE");
		String code = ";IfThenElse_NODE\n";
		code += exp.codeGeneration(env);
		code += "move $fp $sp\n";

		code += "li $t1 1\n";
		
		code += "beq $a0 $t1 " + if_label + "\n";

		
		if(else_statement != null){
			if(else_statement.getStatement().getClass().getName().contains("BlockNode")) {
				//code += blockGen(env, else_statement, code);
				code += else_statement.codeGeneration(env);
			} else {
				code += else_statement.codeGeneration(env);
			}
		}
		code += "branch " + end_label + "\n";
		code += "label " + if_label + ":\n";
		
		if(then_statement.getStatement().getClass().getName().contains("BlockNode")) {
			code += then_statement.codeGeneration(env);
		} else {
				code += then_statement.codeGeneration(env);
		}
			
		
		//
		code += "label " + end_label + ":\n";
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		output.addAll(exp.checkSemantics(env));

		HashMap<String,STentry> hm = new HashMap<>();
		env.getSymTableManagement().addLevel(hm);
		
		Environment envCopy = new Environment(env);
		//envCopy.getSymTableManagement().addLevel(hm);
		
		output.addAll(then_statement.checkSemantics(env));
		if(else_statement!=null){
			output.addAll(else_statement.checkSemantics(envCopy));
		}
		//env.decrementNestingLevel();
		
		//env.getSymTableManagement().removeLevel(env.getNestingLevel());
		
		return output;
	}

	public StatementNode getThenStatement(){
		return then_statement;
	}

	public StatementNode getElseStatement(){
		return else_statement;
	}
	
	
	
	
}