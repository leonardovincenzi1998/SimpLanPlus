package ast.expNode;

import java.util.ArrayList;
import ast.IdNode;
import ast.Node;
import ast.STentry;
import ast.TypeNode;
import util.Environment;
import util.SemanticError;

public class DerExpNode implements ExpNode{
	private final IdNode id;

	public DerExpNode(IdNode id) {
		this.id = id;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		return "DerExpNode " + id.toPrint(indent,env);
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		STentry flag = env.getSymTableManagement().getEntryId(id.getId(), env.getNestingLevel());
		if(flag.getType().getClass().getName().contains("ArrowTypeNode")){
			System.err.println("Wrong usage of function " + id.getId());
			thread.interrupt();
        }
		if(!thread.isInterrupted()){
			if(!flag.getEffect().isInitialized() && !flag.getEffect().isUsed()) {
				System.err.println("The value of the variable " + id.getId() + " isn't defined.");
				thread.interrupt();
			}
		}
		flag.getEffect().setUsed();
		return flag.getType();
	}

	@Override
	public String codeGeneration(Environment env) {
		int nestinglevel = env.getNestingLevel();
		STentry flag = env.getSymTableManagement().getEntryId(id.getId(),nestinglevel);
		
		TypeNode type = (TypeNode)(flag.getType());
		String code = ";LOAD_VARIABLE\n";
		
		//code += "move $al $fp\n";
	  //  code += "lw $al 0($fp)\n";

		code += "move $t2 $fp\n";
		for(int i=0; i < nestinglevel - flag.getNestinglevel(); i++ ) {
	    	code += "lw $fp 0($fp)\n";
	    }
		
		if(flag.isParameter()){
			if(flag.isAnArgumentVar()){
				if(type.getType().equals("int")) {
				//	code += "lw $al 0($al)\n";
				//	code += "lw $al "+flag.getOffset()+"($al)\n";
					code += "lw $fp "+flag.getOffset()+"($fp)\n";
					code += "lw $a0 0($fp)\n";
					
				}
				if (type.getType().equals("bool")) {
					//code += "lb $al 0($al)\n";
					code += "lb $fp "+flag.getOffset()+"($fp)\n";
					code += "lb $a0 0($fp)\n";
				}
			}else{
				if(type.getType().equals("int")) {
					
					//if(nestinglevel != flag.getNestinglevel()) {//
					//	code += "lw $al 0($al)\n";
				//	}//
					
					code += "lw $a0 "+flag.getOffset()+"($fp)\n"; //nuovo
					code += "move $fp $t2\n";

	
					//code += "lw $a0 "+env.getOffsetParametriFunzioni()+"($al)\n";
				}
				if (type.getType().equals("bool")) {
				//	code += "lb $al 0($al)\n";
					code += "lb $a0 "+flag.getOffset()+"($fp)\n";
					//code += "lb $a0 "+env.getOffsetParametriFunzioni()+"($al)\n";
				}
			}
		}else{
			if(type.getType().equals("int")) {
				//code += "lw $a0 "+flag.getOffset()+"($fp)\n"; //nuovo
				//code += "move $fp $t2\n";
				
				code += "lw $a0 " + flag.getOffset() + "($fp)\n";
			}
			if (type.getType().equals("bool")) {
				code += "lb $a0 " + flag.getOffset() + "($fp)\n";
			}
		}
		return code;
	}
	
	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		STentry flag = env.getSymTableManagement().getEntryId(id.getId(), env.getNestingLevel());
		 if(flag == null) {
			 output.add(new SemanticError("The variable "+id.getId()+" isn't declared."));
		 }
		 return output;
	}

	public String getId() {
		return id.getId();
	}
}