package ast;

import java.util.ArrayList;
import java.util.HashMap;
import ast.expNode.ExpNode;
import util.Effect;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusLib;

public class DecVarNode implements Node {
	private final TypeNode type;
	private final IdNode idNode;
	private final ExpNode exp;
	
	public DecVarNode(TypeNode type, IdNode idNode, ExpNode exp) {
		this.type = type;
		this.idNode = idNode;
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		String stringa = "Declaration of variable: "+ type.toPrint(indent,env) + " " + idNode.toPrint(indent,env);
		if(exp != null) {
			stringa += " = " + exp.toPrint(indent,env);
		}
		return stringa;
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		if(this.exp != null) {
			TypeNode expType = (TypeNode)(exp.typeCheck(env));
			if(!thread.isInterrupted()){
				if(expType.getType().equals("void")) {
					System.err.println("The type of the expression isn't valid.");
					thread.interrupt();
				}
				if(!thread.isInterrupted()){
					if(!(SimpLanPlusLib.isSubtype(type,expType,env))) {
						System.err.println("The type of the variable isn't correct.");
						thread.interrupt();
					}
					env.getSymTableManagement().getEntryId(idNode.getId(), env.getNestingLevel()).getEffect().setInitialized();
				}
			}
		}
		return type;
	}

	@Override
	public String codeGeneration(Environment env) {
		String code = "";
		int nestinglevel = env.getNestingLevel(); 
		STentry flag = env.getSymTableManagement().getEntryId(idNode.getId(),nestinglevel);
		int offset = flag.getOffset();
		TypeNode type = (TypeNode)(flag.getType());
		if(this.exp != null){
			code += ";DECLARATION_VARIABLE_INITIALIZED\n";
			code += exp.codeGeneration(env);
			//code += "move $al $fp\n";
			for (int i = 0;i < nestinglevel - flag.getNestinglevel();i++) {
				code += "lw $fp 0($fp)\n";
			}
			if(type.getType().equals("int")) {
				code += "sw $a0 "+ offset +"($fp)\n";
			}
			if(type.getType().equals("bool")) {
				code += "sb $a0 "+ offset +"($fp)\n";
			}
		}
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
	    HashMap<String,STentry> hm = env.getSymTableManagement().getLevel(env.getNestingLevel());
	    STentry flag = new STentry(env.getNestingLevel(),type, env.getOffsetVariabili(),new Effect(false),false,false,false);
        if(hm.put(idNode.getId(),flag) != null) {
			output.add(new SemanticError("The variable " + idNode.getId()+" is already declared."));
        }
        if(exp != null) {
        	output.addAll(exp.checkSemantics(env));
            hm.get(idNode.getId()).getEffect().setInitialized();
        }
		if(type.getType().equals("int")){
			for(int i = 1;i <= 4;i++){
				env.decrementOffsetVariabili();
			}
		}
		if(type.getType().equals("bool")){
			env.decrementOffsetVariabili();
		}
		flag.setOffset(env.getOffsetVariabili());
		return output;
	}

	public IdNode getIdNode() {
		return this.idNode;
	}
}
