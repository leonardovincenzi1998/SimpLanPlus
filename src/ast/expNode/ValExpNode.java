package ast.expNode;

import java.util.ArrayList;
import ast.Node;
import ast.TypeNode;
import util.Environment;
import util.SemanticError;

public class ValExpNode implements ExpNode{
	private final int expVal;

	public ValExpNode(int expVal) {
		this.expVal = expVal;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return "ValExpNode "+this.expVal;
	}

	@Override
	public Node typeCheck(Environment env) {
		return new TypeNode("int");
	}

	@Override
	public String codeGeneration(Environment env) {
		String code = ";LOAD_INTEGER_TO_MEMORY\n";
		code += "li $a0 " + expVal + "\n";
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return new ArrayList<>();
	}
}