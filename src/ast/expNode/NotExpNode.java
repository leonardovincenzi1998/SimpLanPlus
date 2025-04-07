package ast.expNode;

import ast.Node;
import ast.TypeNode;
import util.Environment;
import util.SemanticError;
import java.util.ArrayList;

public class NotExpNode implements ExpNode{
	private final ExpNode expr;

	public NotExpNode(ExpNode expr) {
		this.expr = expr;
	}
	
	@Override
	public String toPrint(String indent,Environment env) {
		return "NotExpNode !" + expr.toPrint(indent,env);
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		TypeNode exprType = (TypeNode) expr.typeCheck(env);
		if(!(exprType.getType().equals("bool"))) {
				System.err.println("The operator requires bool type");
				thread.interrupt();
				return exprType;
		}
		return new TypeNode("bool");
	}
	
	@Override
	public String codeGeneration(Environment env) {
		String code = ";NOT_OPERATION\n";
		code += expr.codeGeneration(env);
		code += "not $a0 $a0\n";
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		return expr.checkSemantics(env);
	}
}