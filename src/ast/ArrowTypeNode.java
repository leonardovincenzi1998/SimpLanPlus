package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class ArrowTypeNode implements Node {
    private final ArrayList<ArgNode> parameterList;
    private final TypeNode typeReturn;

    public ArrowTypeNode (ArrayList<ArgNode> parameterList,TypeNode typeReturn) {
      this.parameterList = parameterList;
      this.typeReturn = typeReturn;
    }

  @Override
  public String toPrint(String indent,Environment env) {
      return "ArrowTypeNode - function with return " + typeReturn.toPrint(indent,env);
  }

  @Override
  public ArrayList<SemanticError> checkSemantics(Environment env) {
	  return new ArrayList<>();
  }

  @Override
  public Node typeCheck (Environment env) {
    return typeReturn;
  }

  @Override
  public String codeGeneration(Environment env) {
		return "";
  }

  public ArrayList<ArgNode> getParlist(){
      return parameterList;
  }
} 