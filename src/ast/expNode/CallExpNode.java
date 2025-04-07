package ast.expNode;

import ast.CallNode;
import ast.Node;
import util.Environment;
import util.SemanticError;
import java.util.ArrayList;

public class CallExpNode implements ExpNode{
	public CallNode visitCall;

	public CallExpNode(CallNode visitCall) {
		this.visitCall = visitCall;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return visitCall.toPrint(indent,env);
	}

	@Override
	public Node typeCheck(Environment env){
		return visitCall.typeCheck(env);
	}

	@Override
	public String codeGeneration(Environment env){
		return visitCall.codeGeneration(env);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		return visitCall.checkSemantics(env);
	}

	public CallNode getCall(){
		return visitCall;
	}
}
