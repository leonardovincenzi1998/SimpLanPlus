package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class TypeNode implements Node {
	private final String type;

	public TypeNode(String type) {
		this.type = type;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return "TypeNode " + type ;
	}

	@Override
	public Node typeCheck(Environment env) {
		return null;
	}

	@Override
	public String codeGeneration(Environment env) {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return new ArrayList<>();
	}

	public String getType(){
		return type;
	}
}
