package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class DeclarationNode implements Node {
	private final Node declaration;

	public DeclarationNode(Node declaration) {
		this.declaration = declaration;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return indent + declaration.toPrint(indent,env) + "\n";
	}

	@Override
	public Node typeCheck(Environment env) {
		return declaration.typeCheck(env);
	}

	@Override
	public String codeGeneration(Environment env) {
		return declaration.codeGeneration(env);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return declaration.checkSemantics(env);
	}

	public Node getDeclaration(){
		return declaration;
	}
}
