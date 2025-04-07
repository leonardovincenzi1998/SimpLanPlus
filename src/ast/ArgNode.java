package ast;

import java.util.ArrayList;
import java.util.HashMap;
import util.Effect;
import util.Environment;
import util.SemanticError;

public class ArgNode implements Node{
	private final boolean var;
	private final TypeNode type;
	private final IdNode idNode;

	public ArgNode(boolean var,TypeNode type, IdNode idNode) {
		this.var = var;
		this.type = type;
		this.idNode = idNode;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		String stringa = "ArgNode ";
		if(var){
			stringa += "var ";
		}
		stringa += type.toPrint(indent,env) + " " + idNode.toPrint(indent,env);
		return stringa;
	}

	@Override
	public Node typeCheck(Environment env) {
		return type;
	}

	@Override
	public String codeGeneration(Environment env) {
		return "";
	}
	
	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		env.incrementNestingLevel();
		HashMap<String,STentry> hm = env.getSymTableManagement().getSymbolTable().get(env.getNestingLevel());
		STentry entry = new STentry(env.getNestingLevel(),type,env.getOffsetParametriFunzioni(),new Effect(true),false,true,var);
	//	System.out.println("nl param: " + env.getNestingLevel());
		env.decrementOffsetParametriFunzioni();
		//entry.setOffset(env.getOffsetParametriFunzioni());
		//System.out.println("offParamFunArg: " + env.getOffsetParametriFunzioni());
		if(hm.put(idNode.getId(),entry) != null){
			output.add(new SemanticError("The argument "+idNode.getId()+" is already defined."));
		}
		env.decrementNestingLevel();
		return output;
	}
	
	public TypeNode getType(){
        return type;
    }
	
	public boolean getVar() {
		return var;
	}

	public String getId() {
		return idNode.getId();
	}
}
