package ast;

import java.util.ArrayList;
import ast.expNode.ExpNode;
import util.Environment;
import util.SemanticError;

public class RetNode implements Node {
	private final ExpNode exp;
	
	public RetNode(ExpNode exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		if(exp != null){
			return "RetNode " + exp.toPrint(indent,env);
		}
		return "RetNode";
	}

	@Override
	public Node typeCheck(Environment env) {
		if(exp != null) {
			return exp.typeCheck(env);
		}
		return new TypeNode("void");
	}

	@Override
	public String codeGeneration(Environment env) {
		//nel linguaggio simplanplus non esistono le funzioni annidate, e le funzioni dichiarate all'interno
		//di blocchi (anche dovuti agli if). Tutte le funzioni sono dichiarate al livello di nesting level 0,
		//l'operazione di return quindi ha come obiettivo di uscire da tutti i blocchi e continuare dall'istruzione
		//successiva alla chiamata di funzione.
		String code = ";RETURN_NODE\n";
		if(exp != null){
			code += exp.codeGeneration(env);
		}
		for(int i = env.getNestingLevel();i > 0;i--){
			int memorySpace = env.getSymTableManagement().computeMemorySpace(i);
			code += "move $sp $fp\n";
			code += "$fp <- top\n";
			code += "pop\n";
			code += "addi $sp $sp " + memorySpace + "\n";
			if(i == 1){
				code += "$ra <- top\n";
				code += "pop\n";
			}
		}
		code += "jr $ra\n";
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		if(exp != null) {
			output.addAll(exp.checkSemantics(env));
		}
		return output;
	}

	public ExpNode getExp() {
		return this.exp;
	}
}
