package ast.expNode;

import java.util.ArrayList;
import ast.Node;
import ast.TypeNode;
import util.SimpLanPlusLib;
import util.SemanticError;
import util.Environment;

public class BinExpNode implements ExpNode{
	private final ExpNode first;
	private final ExpNode second;
	private final String operator;

	public BinExpNode(ExpNode first, ExpNode second, String operator) {
		this.first = first;
		this.second = second;
		this.operator = operator;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		String operator1 = "";
		if(operator.contains("'+'")){
			operator1 = "+";
		}
		if(operator.contains("'-'")){
			operator1 = "-";
		}
		if(operator.contains("'*'")){
			operator1 = "*";
		}
		if(operator.contains("'/'")){
			operator1 = "/";
		}
		if(operator.contains("'<'")){
			operator1 = "<";
		}
		if(operator.contains("'>'")){
			operator1 = ">";
		}
		if(operator.contains("'<='")){
			operator1 = "<=";
		}
		if(operator.contains("'>='")){
			operator1 = ">=";
		}
		if(operator.contains("'&&'")){
			operator1 = "&&";
		}
		if(operator.contains("'||'")){
			operator1 = "||";
		}
		if(operator.contains("==")){
			operator1 = "==";
		}
		if(operator.contains("!=")){
			operator1 = "!=";
		}
		return "BinExpNode " + first.toPrint(indent,env) + " " + operator1 + " " + second.toPrint(indent,env);
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		if (!(SimpLanPlusLib.isSubtype(first.typeCheck(env),second.typeCheck(env),env))){
			System.err.println("Terms type mismatch");
			thread.interrupt();
		}
		if(!thread.isInterrupted()){
			TypeNode firstType = (TypeNode) first.typeCheck(env);
			if(operator.contains("'+'") || operator.contains("'-'") || operator.contains("'*'") || operator.contains("'/'") || operator.contains("'<'") || operator.contains("'>'")
					|| operator.contains("'<='") || operator.contains("'>='")) {
				if(!(firstType.getType().equals("int"))) {
					System.err.println("The operator requires int type");
					thread.interrupt();
				}
				if(!thread.isInterrupted()){
					if(operator.contains("'+'") || operator.contains("'-'") || operator.contains("'*'") || operator.contains("'/'")) {
						return new TypeNode("int");
					}
					if(operator.contains("'<'") || operator.contains("'>'") || operator.contains("'<='") || operator.contains("'>='")) {
						return new TypeNode("bool");
					}
				}
			}else if(operator.contains("'&&'") || operator.contains("'||'")) {
				if(!(firstType.getType().equals("bool"))) {
					System.err.println("The operator requires bool type");
					thread.interrupt();
				}
				if(!thread.isInterrupted()){
					return new TypeNode("bool");
				}
			}else if(operator.contains("==") || operator.contains("!=")) {
				return new TypeNode("bool");
			}else{
				System.err.println("The binary operation doesn't exist.");
				thread.interrupt();
			}
		}
		return null;
	}

	@Override
	public String codeGeneration(Environment env) {
		String end_operation = SimpLanPlusLib.newLabel("END_OPERATION");
		String out_operation = SimpLanPlusLib.newLabel("OUT_OPERATION");
		String code = "";
		if(operator.contains("'+'")) {
			code += ";SUM_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "add $a0 $t1 $a0\n";
			code += "pop\n";
		}else if(operator.contains("'-'")) {
			//System.out.println("c'è la sottrazione");
			code += ";SUBSTRACT_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "sub $a0 $t1 $a0\n";
			code += "pop\n";
		}else if(operator.contains("'*'")) {
			code += ";MULTIPLY_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "mult $a0 $t1 $a0\n";
			code += "pop\n";
		}else if(operator.contains("'/'")) {
			code += ";DIVISION_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "div $a0 $t1 $a0\n";
			code += "pop\n";
		}else if(operator.contains("'&&'")) {
			code += ";LOGICAL_AND\n";
			code += first.codeGeneration(env);
			code += "li $t1 0\n";
			code += "beq $a0 $t1 " + end_operation + "\n";
			code += second.codeGeneration(env);
			code += "li $t1 0\n";
			code += "beq $a0 $t1 " + end_operation + "\n";
			code += "li $a0 1\n";
			code += "branch " + out_operation + "\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 0\n";
			code += "label " + out_operation + ":\n";
		}else if(operator.contains("'||'")) {
			code += ";LOGICAL_OR\n";
			code += first.codeGeneration(env);
			code += "li $t1 1\n";
			code += "beq $a0 $t1 " + end_operation + "\n";
			code += second.codeGeneration(env);
			code += "li $t1 1\n";
			code += "beq $a0 $t1 " + end_operation + "\n";
			code += "li $a0 0\n";
			code += "branch " + out_operation + "\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 1\n";
			code += "label " + out_operation + ":\n";
		}else if(operator.contains("'>'")) {
			code += ";MAJOR_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "bgt $t1 $a0 " + end_operation + "\n";
			code += "li $a0 0\n";
			code += "branch "+out_operation+"\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 1\n";
			code += "label " + out_operation + ":\n";
			code += "pop\n";
		}else if(operator.contains("'>='")) {
			code += ";MAJOR_EQUAL_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "bgeq $t1 $a0 " + end_operation + "\n";
			code += "li $a0 0\n";
			code += "branch "+out_operation+"\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 1\n";
			code += "label " + out_operation + ":\n";
			code += "pop\n";
		}else if(operator.contains("'<='")) {
			code += ";MINOR_EQUAL_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "bleq $t1 $a0 " + end_operation + "\n";
			code += "li $a0 0\n";
			code += "branch "+out_operation+"\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 1\n";
			code += "label " + out_operation + ":\n";
			code += "pop\n";
		}else if(operator.contains("'<'")) {
			code += ";MINOR_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "blt $t1 $a0 " + end_operation + "\n";
			code += "li $a0 0\n";
			code += "branch "+out_operation+"\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 1\n";
			code += "label " + out_operation + ":\n";
			code += "pop\n";
		}else if(operator.contains("'=='")) {
			code += ";EQUAL_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "beq $a0 $t1 " + end_operation + "\n";
			code += "li $a0 0\n";
			code += "branch "+out_operation+"\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 1\n";
			code += "label " + out_operation + ":\n";
			code += "pop\n";
		}else if(operator.contains("'!='")) {
			code += ";NOT_EQUAL_OPERATION\n";
			code += first.codeGeneration(env);
			code += "push $a0\n";
			code += second.codeGeneration(env);
			code += "$t1 <- top\n";
			code += "bne $a0 $t1 " + end_operation + "\n";
			code += "li $a0 0\n";
			code += "branch "+out_operation+"\n";
			code += "label " + end_operation + ":\n";
			code += "li $a0 1\n";
			code += "label " + out_operation + ":\n";
			code += "pop\n";
		}
		return code;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env){
		ArrayList<SemanticError> output = new ArrayList<>();
		if(this.first != null) {
			output.addAll(first.checkSemantics(env));
		}else{
			output.add(new SemanticError("The first term of the operation is null."));
		}
		if(this.second != null) {
			output.addAll(second.checkSemantics(env));
		}else{
			output.add(new SemanticError("The second term of the operation is null."));
		}
		return output;
	}
}