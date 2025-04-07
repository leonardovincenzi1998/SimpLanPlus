package ast.expNode;

import ast.Node;
import util.Environment;
import util.SemanticError;
import java.util.ArrayList;

public class BaseExpNode implements ExpNode{
	private final ExpNode visit;
	
	public BaseExpNode(ExpNode visit) {
		this.visit=visit;
	}
	
	@Override
	public String toPrint(String indent,Environment env) {
		return "BaseExpNode (" + visit.toPrint(indent,env) + ")";
	}

	@Override
	public Node typeCheck(Environment env){
		return visit.typeCheck(env);
	}

	@Override
	public String codeGeneration(Environment env){
		return visit.codeGeneration(env);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		return visit.checkSemantics(env);
	}

}