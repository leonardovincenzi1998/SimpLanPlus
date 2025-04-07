package ast;

import java.util.ArrayList;
import ast.expNode.CallExpNode;
import ast.expNode.ExpNode;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusLib;

public class AssignmentNode implements Node {
	private final IdNode idNode;
	private final ExpNode exp;
	
	public AssignmentNode(IdNode idNode, ExpNode exp) {
		this.idNode = idNode;
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return "AssignmentNode "+ idNode.toPrint(indent,env) + " = " + exp.toPrint(indent,env);
	}

	@Override
	public Node typeCheck (Environment env) {
		Thread thread = Thread.currentThread();
		STentry flag = env.getSymTableManagement().getEntryId(idNode.getId(), env.getNestingLevel());
		if(flag.getType().getClass().getName().contains("ArrowTypeNode")){
			System.err.println("The function " + idNode.getId() + " can't be used in this statement.");
			thread.interrupt();
		}
		if(!thread.isInterrupted()){
			Node typeExp1 = exp.typeCheck(env);
			if(!thread.isInterrupted()){
				TypeNode typeExpression = (TypeNode)(typeExp1);
				if(typeExpression.getType().equals("void")){
					if(exp.getClass().getName().contains("CallExpNode")){
						CallExpNode call = (CallExpNode)(exp);
						CallNode call1 = call.getCall();
						System.err.println("The function " + call1.getIdNode().getId() + " can't be assigned in an expression.");
						thread.interrupt();
					}
				}
				if(!thread.isInterrupted()){
					if (!(SimpLanPlusLib.isSubtype(flag.getType(), typeExpression,env))) {
						System.err.println("Incompatible value for variable " + idNode.getId());
						thread.interrupt();
					}
				}
			}
		}
		flag.getEffect().setUsed();
		return flag.getType();
	}

	@Override
	public String codeGeneration(Environment env) {
		int nestinglevel = env.getNestingLevel();
		STentry flag = env.getSymTableManagement().getEntryId(idNode.getId(),nestinglevel);
		int offset = flag.getOffset();
		TypeNode type = (TypeNode)(flag.getType());
		String code = ";ASSIGNMENT_NODE\n";
		code += exp.codeGeneration(env);
		
		/*if(env.getNestingLevel()==0) {
			code += "move $al $fp\n";

		}else {
		    code += "lw $al 0($fp)\n";

		}
		*/
		
		for (int i = 0;i < nestinglevel - flag.getNestinglevel();i++) {
			code += "lw $fp 0($fp)\n";
		}
		if(type.getType().equals("int")) {
			code += "sw $a0 "+ offset +"($fp)\n";
		}
		if(type.getType().equals("bool")) {
			code += "sb $a0 "+ offset +"($fp)\n";
		}
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		STentry flag = env.getSymTableManagement().getEntryId(idNode.getId(), env.getNestingLevel());
		if(flag != null) {
			output.addAll(exp.checkSemantics(env));
			flag.getEffect().setUsed();
		} else {
			output.add(new SemanticError("The variable " + idNode.getId() + " isn't declared."));
		}
		return output;
	}
}