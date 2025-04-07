package ast;

import java.util.ArrayList;
import ast.expNode.ExpNode;
import util.Environment;
import util.SemanticError;

public class PrintNode implements Node {
	private final ExpNode exp;
	
	public PrintNode(ExpNode exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return "PrintNode " + exp.toPrint(indent,env);
	}

	@Override
	public Node typeCheck(Environment env) {
		return exp.typeCheck(env);
	}

	@Override
	public String codeGeneration(Environment env) {
		String code = ";PRINT_NODE\n";
		code += exp.codeGeneration(env);
		code += "print $a0\n";
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return exp.checkSemantics(env);
	}
}