package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class StatementNode implements Node {
	private final Node statement;
	
	public StatementNode(Node statement) {
		this.statement = statement;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return indent + statement.toPrint(indent,env) + "\n";
	}

	@Override
	public Node typeCheck(Environment env) {
		return statement.typeCheck(env);
	}

	@Override
	public String codeGeneration(Environment env) {
		return statement.codeGeneration(env);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		if(this.statement != null) {
			output.addAll(this.statement.checkSemantics(env));
		}
		return output;
	}
	
	public Node getStatement() {
		return this.statement;
	}
}