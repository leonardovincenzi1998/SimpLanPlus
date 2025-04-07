package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class IdNode implements Node {
	private final String id;
	
	public IdNode(String text) {
		id = text;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return "IdNode "+ id;
	}

	@Override
	public Node typeCheck(Environment env) {
		return env.getSymTableManagement().getEntryId(id,env.getNestingLevel()).getType();
	}

	@Override
	public String codeGeneration(Environment env) {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return new ArrayList<>();
	}

	public String getId() {
		return id;
	}
}