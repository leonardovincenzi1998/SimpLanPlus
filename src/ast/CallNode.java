package ast;

import java.util.ArrayList;
import ast.expNode.ExpNode;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusLib;

public class CallNode implements Node {
	private final IdNode idNode;
	private final ArrayList<ExpNode> expressions;
	
	public CallNode(IdNode idNode, ArrayList<ExpNode> expressions) {
		this.idNode = idNode;
		if(expressions == null) {
			this.expressions = new ArrayList<>();
		}else {
			this.expressions = expressions;
		}
	}

	@Override
	public String toPrint(String indent,Environment env) {
		String stringa = "CallNode " + idNode.toPrint(indent,env) + "(";
		int i = 0;
		for(ExpNode exp:expressions) {
			stringa += exp.toPrint(indent,env);
			if(i < (expressions.size() - 1)){
				stringa += ",";
			}
			i++;
		}
		stringa += ")";
		return stringa;
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		STentry flag = env.getSymTableManagement().getEntryId(idNode.getId(), env.getNestingLevel());
		if(!(flag.getType().getClass().getName().contains("ArrowTypeNode"))){
			System.err.println("Invocation of a non-function "+idNode.getId());
			thread.interrupt();
		}
		if(!thread.isInterrupted()){
			ArrowTypeNode typeFunction = (ArrowTypeNode) (flag.getType());
			ArrayList<ArgNode> parList = typeFunction.getParlist();
			if(parList.size() != expressions.size()){
				System.err.println("Wrong number of parameters in the invocation of "+idNode.getId());
				thread.interrupt();
			}
			if(!thread.isInterrupted()){
				int i = 0;
				for(ExpNode singleExp:expressions){
					if(!thread.isInterrupted()){
						if(!(SimpLanPlusLib.isSubtype(singleExp.typeCheck(env),parList.get(i).getType(),env))) {
							if((i+1) == 1)
								System.err.println("Wrong type for "+(i+1)+"-st parameter in the invocation of "+idNode.getId());
							if((i+1) == 2)
								System.err.println("Wrong type for "+(i+1)+"-nd parameter in the invocation of "+idNode.getId());
							if((i+1) == 3)
								System.err.println("Wrong type for "+(i+1)+"-rd parameter in the invocation of "+idNode.getId());
							if((i+1) > 3)
								System.err.println("Wrong type for "+(i+1)+"-th parameter in the invocation of "+idNode.getId());
							thread.interrupt();
						}
						if(parList.get(i).getVar()) {
							if(!(singleExp.getClass().getName().contains("DerExpNode"))) {
								System.err.println("The argument " + parList.get(i).getId() + " of the function requests var.");
								thread.interrupt();
							}
						}
					}
					i++;
				}
			}
		}
		flag.getEffect().setUsed();
		return flag.getType().typeCheck(env);
	}
	
	@Override
	public String codeGeneration(Environment env) {
		int nestinglevel = env.getNestingLevel();
		//STentry flagFunction = env.getSymTableManagement().getEntryId(idNode.getId(),nestinglevel);
		String code = ";CALL_NODE\n";
	    code += "push $fp\n";
	    
		code += "move $fp $sp\n";
		//code += "addi $fp $fp 1\n";
	    

	/*	if(env.getNestingLevel() == 0) {
			code += "move $fp $sp\n";
			for (int i=0; i < expressions.size(); i++) {
				 code += expressions.get(i).codeGeneration(env);
			      code += "push $a0\n";
			}
		} else {
			//code += "move $fp $sp\n";

			for (int i=0; i < expressions.size(); i++) {
				 code += expressions.get(i).codeGeneration(env);
			     code += "push $a0\n";
			}
			     //code += "move $fp $sp\n";

		}	
		*/	
		for (int i=0; i < expressions.size(); i++) {
			 code += expressions.get(i).codeGeneration(env);
		      code += "push $a0\n";
		}

	    code += "jal " + idNode.getId() + "\n";
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		STentry flag = env.getSymTableManagement().getEntryId(idNode.getId(), env.getNestingLevel());
		if(flag == null){
			output.add(new SemanticError("The function " + idNode.getId() + " doesn't exist."));
		}else{
			if(expressions.size() > 0){
				for(ExpNode singleExpression:expressions){
					output.addAll(singleExpression.checkSemantics(env));
				}
			}
			flag.getEffect().setUsed();
		}
		return output;
	}

	public IdNode getIdNode(){
		return idNode;
	}
}