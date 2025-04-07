package ast;

import java.util.ArrayList;
import java.util.HashMap;
import util.Effect;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusLib;

public class DecFunNode implements Node {
	private final TypeNode type;
	private final IdNode idNode;
	private final ArrayList<ArgNode> args;
	private final BlockNode block;
	private Environment internalEnv;

	public DecFunNode(TypeNode type, IdNode idNode, ArrayList<ArgNode> args, BlockNode block) {
		this.type = type;
		this.idNode = idNode;
		this.args = args;
		this.block = block;
	}

	@Override
	public String toPrint(String indent,Environment env) {
		String stringa = "Declaration of function: ";
		stringa += type.toPrint(indent,internalEnv) + " ";
		stringa += idNode.toPrint(indent,internalEnv) + "(";
		for(int i = 0;i < args.size();i++) {
			stringa += args.get(i).toPrint(indent,internalEnv);
			if(i < (args.size() - 1)){
				stringa += ",";
			}
		}
		stringa += ")\n" + indent + indent + block.toPrint(indent,internalEnv);
		return stringa;
	}

	@Override
	public Node typeCheck(Environment env) {
		Thread thread = Thread.currentThread();
		if(type.getType().equals("void")) {
			block.typeCheck(internalEnv);
			if(!thread.isInterrupted()){
				ArrayList<StatementNode> statements = block.getStatements();
				for(StatementNode stat: statements) {
					if(!thread.isInterrupted()){
						if(stat.getStatement().getClass().getName().contains("RetNode")){
							RetNode returns = (RetNode)(stat.getStatement());
							//In questo modo con void si accetta che venga scritto solo Return (senza exp) o che non ci sia proprio
							if(returns.getExp() != null) {
								System.err.println("The function must return void");
								thread.interrupt();
							}
						}
					}
				}
			}
		}else{
			TypeNode retType = (TypeNode)(block.typeCheck(internalEnv));
			if(!thread.isInterrupted()){
				if(retType.getType().equals("void")) {
					System.err.println("This function must return " + type.toPrint("",internalEnv));
					thread.interrupt();
				}
				if(!thread.isInterrupted()){
					if (!(SimpLanPlusLib.isSubtype(retType,type,internalEnv))){
						System.err.println("Wrong return type for function "+idNode.getId());
						thread.interrupt();
					}
				}
			}
		}
		return type;
	}

	@Override
	public String codeGeneration(Environment env) {
		//int memorySpace = block.getInternalEnv().getSymTableManagement().computeMemorySpace(block.getInternalEnv().getNestingLevel());
		int memorySpace = internalEnv.getSymTableManagement().computeMemorySpace(internalEnv.getNestingLevel());

		String end_function = SimpLanPlusLib.newLabel("END_FUNCTION_"+idNode.getId());
		String code = ";DEC_FUN_NODE\n";
		code += "branch " + end_function + "\n";
		code += "label " + idNode.getId() + ":\n";

	//code += "move $fp $sp\n";

		code += "push $ra\n";


		code += block.codeGeneration(env);
		
		
		code += "$ra <- top\n";
		code += "pop\n";
		//code += "pop\n";
		
		for (int i = 0;i < args.size();i++) {
	    	code += "pop\n";
	    }
		code += "$fp <- top\n";
		code += "pop\n";
		//code += ((memorySpace > 0) ? "addi $sp $sp " + memorySpace + "\n" : "");

		code += "jr $ra\n";
		code += "label " + end_function + ":\n";
		return code;

	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> output = new ArrayList<>();
		HashMap<String,STentry> hm = env.getSymTableManagement().getLevel(env.getNestingLevel());
		STentry entry = new STentry(env.getNestingLevel(),new ArrowTypeNode(args,type),0,new Effect(true),true,false,false);
		Environment internalEnv = new Environment(env);
		if(hm.put(idNode.getId(),entry) != null) {
			output.add(new SemanticError("The function " + idNode.getId()+" is already declared."));
		}else{
			HashMap<String,STentry> hm1= new HashMap<>();
			internalEnv.getSymTableManagement().getLevel(internalEnv.getNestingLevel()).put(idNode.getId(),entry);

			internalEnv.getSymTableManagement().addLevel(hm1);

			internalEnv.setOffsetParametriFunzioni(-1);
			if(args.size() > 0) {
				for(ArgNode argument : args) {
					//System.out.println("internal env: " + internalEnv.getNestingLevel());
					//internalEnv.incrementNestingLevel();
					output.addAll(argument.checkSemantics(internalEnv));
				}
			}
			

			if(block.getStatements().isEmpty() && block.getDeclarations().isEmpty()) {
				output.add(new SemanticError("The body of the function is empty."));
			} else {
				//internalEnv.incrementNestingLevel();
				output.addAll(block.checkSemantics(internalEnv));
				//internalEnv.decrementNestingLevel();
			}
		}
		this.internalEnv=internalEnv;
		return output;
	}

	public BlockNode getBlock(){
		return block;
	}
}