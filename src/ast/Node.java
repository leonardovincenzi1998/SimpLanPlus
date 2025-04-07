package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public interface Node{
	String toPrint(String indent,Environment env);

	Node typeCheck(Environment env);

	String codeGeneration(Environment env);

	ArrayList<SemanticError> checkSemantics(Environment env);
}