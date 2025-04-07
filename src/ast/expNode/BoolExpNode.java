package ast.expNode;

import java.util.ArrayList;
import ast.Node;
import ast.TypeNode;
import util.Environment;
import util.SemanticError;

public class BoolExpNode implements ExpNode{
	private final boolean parseBoolean;

	public BoolExpNode(boolean parseBoolean) {
		this.parseBoolean = parseBoolean;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		if(parseBoolean){
			return "BoolExpNode true";
		}
		return "BoolExpNode false";
	}

	@Override
	public Node typeCheck(Environment env) {
		return new TypeNode("bool");
	}

	@Override
	public String codeGeneration(Environment env) {
		String code = ";LOAD_BOOLEAN_TO_MEMORY\n";
		if(parseBoolean) {
			code += "li $a0 1\n";
		}else{
			code += "li $a0 0\n";
		}
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		return new ArrayList<>();
	}
}
