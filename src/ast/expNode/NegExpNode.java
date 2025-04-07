package ast.expNode;

import ast.Node;
import ast.TypeNode;
import util.Environment;
import util.SemanticError;
import java.util.ArrayList;

public class NegExpNode implements ExpNode{
	private final ExpNode expr;

	public NegExpNode(ExpNode expr) {
		this.expr = expr;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return "NegExpNode -" + expr.toPrint(indent,env);
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		TypeNode exprType = (TypeNode) expr.typeCheck(env);
		if(!(exprType.getType().equals("int"))) {
				System.err.println("The operator requires int type");
				thread.interrupt();
				return exprType;
		}
		return new TypeNode("int");
	}
	
	@Override
	public String codeGeneration(Environment env) {
		String code = ";NEGATION_OPERATION\n";
		code += expr.codeGeneration(env);
		code += "neg $a0 $a0\n";
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		return expr.checkSemantics(env);
	}
}