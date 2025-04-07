package Interpreter;

import parser.SVMBaseVisitor;
import parser.SVMParser.AddContext;
import parser.SVMParser.AddiContext;
import parser.SVMParser.AndContext;
import parser.SVMParser.AssemblyContext;
import parser.SVMParser.BeqContext;
import parser.SVMParser.DivContext;
import parser.SVMParser.DiviContext;
import parser.SVMParser.BgtContext;
import parser.SVMParser.BgeqContext;
import parser.SVMParser.BleqContext;
import parser.SVMParser.BltContext;
import parser.SVMParser.BneContext;
import parser.SVMParser.HaltContext;
import parser.SVMParser.InstructionContext;
import parser.SVMParser.JalContext;
import parser.SVMParser.BranchContext;
import parser.SVMParser.JrContext;
import parser.SVMParser.LabelContext;
import parser.SVMParser.LbContext;
import parser.SVMParser.LiContext;
import parser.SVMParser.LwContext;
import parser.SVMParser.MoveContext;
import parser.SVMParser.MultContext;
import parser.SVMParser.MultiContext;
import parser.SVMParser.NegContext;
import parser.SVMParser.NotContext;
import parser.SVMParser.OrContext;
import parser.SVMParser.PopContext;
import parser.SVMParser.PrintContext;
import parser.SVMParser.RetContext;
import parser.SVMParser.PushContext;
import parser.SVMParser.SbContext;
import parser.SVMParser.SubContext;
import parser.SVMParser.SubiContext;
import parser.SVMParser.SwContext;
import parser.SVMParser.TopContext;
import java.util.ArrayList;

public class SVMVisitorImpl extends SVMBaseVisitor<SVMNode> {
	@Override
	public SVMNode visitAssembly(AssemblyContext ctx) {
		Thread thread = Thread.currentThread();
		ArrayList<InstructionNode> instructionsList = new ArrayList<>();
		for(InstructionContext singleInstruction:ctx.instruction()){
			if(!thread.isInterrupted()){
				instructionsList.add((InstructionNode)(visitInstruction(singleInstruction)));
			}
		}
		return new AssemblyNode(instructionsList);
	}

	@Override
	public SVMNode visitInstruction(InstructionContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.push() != null){
				return visitPush(ctx.push());
			}
			if(ctx.pop() != null){
				return visitPop(ctx.pop());
			}
			if(ctx.top() != null){
				return visitTop(ctx.top());
			}
			if(ctx.li() != null){
				return visitLi(ctx.li());
			}
			if(ctx.move() != null){
				return visitMove(ctx.move());
			}
			if(ctx.lw() != null){
				return visitLw(ctx.lw());
			}
			if(ctx.sw() != null){
				return visitSw(ctx.sw());
			}
			if(ctx.lb() != null){
				return visitLb(ctx.lb());
			}
			if(ctx.sb() != null){
				return visitSb(ctx.sb());
			}
			if(ctx.add() != null){
				return visitAdd(ctx.add());
			}
			if(ctx.addi() != null){
				return visitAddi(ctx.addi());
			}
			if(ctx.sub() != null){
				return visitSub(ctx.sub());
			}
			if(ctx.subi() != null){
				return visitSubi(ctx.subi());
			}
			if(ctx.mult() != null){
				return visitMult(ctx.mult());
			}
			if(ctx.multi() != null){
				return visitMulti(ctx.multi());
			}
			if(ctx.div() != null) {
				return visitDiv(ctx.div());
			}
			if(ctx.divi() != null){
				return visitDivi(ctx.divi());
			}
			if(ctx.bgt() != null){
				return visitBgt(ctx.bgt());
			}
			if(ctx.bgeq() != null){
				return visitBgeq(ctx.bgeq());
			}
			if(ctx.bleq() != null){
				return visitBleq(ctx.bleq());
			}
			if(ctx.blt() != null){
				return visitBlt(ctx.blt());
			}
			if(ctx.bne() != null){
				return visitBne(ctx.bne());
			}
			if(ctx.and() != null){
				return visitAnd(ctx.and());
			}
			if(ctx.or() != null){
				return visitOr(ctx.or());
			}
			if(ctx.not() != null){
				return visitNot(ctx.not());
			}
			if(ctx.neg() != null){
				return visitNeg(ctx.neg());
			}
			if(ctx.print() != null){
				return visitPrint(ctx.print());
			}
			if(ctx.ret() != null){
				return visitRet(ctx.ret());
			}
			if(ctx.beq() != null){
				return visitBeq(ctx.beq());
			}
			if(ctx.label() != null){
				return visitLabel(ctx.label());
			}
			if(ctx.jal() != null){
				return visitJal(ctx.jal());
			}
			if(ctx.branch() != null){
				return visitBranch(ctx.branch());
			}
			if(ctx.jr() != null){
				return visitJr(ctx.jr());
			}
			if(ctx.halt() != null){
				return visitHalt(ctx.halt());
			}
		}
		return null;
	}

	@Override
	public SVMNode visitPush(PushContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.src == null){
				System.err.println("Error during the execution: in the push instruction the parameter must not be null.");
				thread.interrupt();
				return new InstructionNode("push");
			}
			return new InstructionNode("push",ctx.src.getText());
		}
		return new InstructionNode("push");
	}

	@Override
	public SVMNode visitPop(PopContext ctx) {
		return new InstructionNode("pop");
	}

	@Override
	public SVMNode visitTop(TopContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null){
				System.err.println("Error during the execution: in the top instruction the parameter must not be null.");
				thread.interrupt();
				return new InstructionNode("top");
			}
			return new InstructionNode("top",ctx.destination.getText());
		}
		return new InstructionNode("top");
	}

	@Override
	public SVMNode visitLi(LiContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.numbers == null){
				System.err.println("Error during the execution: in the li instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("li");
			}
			return new InstructionNode("li",ctx.destination.getText(),ctx.numbers.getText());
		}
		return new InstructionNode("li");
	}

	@Override
	public SVMNode visitMove(MoveContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.departure == null){
				System.err.println("Error during the execution: in the move instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("move");
			}
			return new InstructionNode("move",ctx.destination.getText(),ctx.departure.getText());
		}
		return new InstructionNode("move");
	}

	@Override
	public SVMNode visitLw(LwContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.offset == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the lw instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("lw");
			}
			return new InstructionNode("lw",ctx.register1.getText(),ctx.offset.getText(),ctx.register2.getText());
		}
		return new InstructionNode("lw");
	}

	@Override
	public SVMNode visitSw(SwContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.offset == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the sw instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("sw");
			}
			return new InstructionNode("sw",ctx.register1.getText(),ctx.offset.getText(),ctx.register2.getText());
		}
		return new InstructionNode("sw");
	}

	@Override
	public SVMNode visitLb(LbContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.offset == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the lb instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("lb");
			}
			return new InstructionNode("lb",ctx.register1.getText(),ctx.offset.getText(),ctx.register2.getText());
		}
		return new InstructionNode("lb");
	}

	@Override
	public SVMNode visitSb(SbContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.offset == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the sb instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("sb");
			}
			return new InstructionNode("sb",ctx.register1.getText(),ctx.offset.getText(),ctx.register2.getText());
		}
		return new InstructionNode("sb");
	}

	@Override
	public SVMNode visitAdd(AddContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the add instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("add");
			}
			return new InstructionNode("add",ctx.destination.getText(),ctx.register1.getText(),ctx.register2.getText());
		}
		return new InstructionNode("add");
	}

	@Override
	public SVMNode visitAddi(AddiContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.value == null){
				System.err.println("Error during the execution: in the addi instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("addi");
			}
			return new InstructionNode("addi",ctx.destination.getText(),ctx.register1.getText(),ctx.value.getText());
		}
		return new InstructionNode("addi");
	}

	@Override
	public SVMNode visitSub(SubContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the sub instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("sub");
			}
			return new InstructionNode("sub",ctx.destination.getText(),ctx.register1.getText(),ctx.register2.getText());
		}
		return new InstructionNode("sub");
	}

	@Override
	public SVMNode visitSubi(SubiContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.value == null){
				System.err.println("Error during the execution: in the subi instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("subi");
			}
			return new InstructionNode("subi",ctx.destination.getText(),ctx.register1.getText(),ctx.value.getText());
		}
		return new InstructionNode("subi");
	}

	@Override
	public SVMNode visitMult(MultContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the mult instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("mult");
			}
			return new InstructionNode("mult",ctx.destination.getText(),ctx.register1.getText(),ctx.register2.getText());
		}
		return new InstructionNode("mult");
	}

	@Override
	public SVMNode visitMulti(MultiContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.value == null){
				System.err.println("Error during the execution: in the multi instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("multi");
			}
			return new InstructionNode("multi",ctx.destination.getText(),ctx.register1.getText(),ctx.value.getText());
		}
		return new InstructionNode("multi");
	}

	@Override
	public SVMNode visitDiv(DivContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the div instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("div");
			}
			return new InstructionNode("div",ctx.destination.getText(),ctx.register1.getText(),ctx.register2.getText());
		}
		return new InstructionNode("div");
	}

	@Override
	public SVMNode visitDivi(DiviContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.value == null){
				System.err.println("Error during the execution: in the divi instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("divi");
			}
			return new InstructionNode("divi",ctx.destination.getText(),ctx.register1.getText(),ctx.value.getText());
		}
		return new InstructionNode("divi");
	}

	@Override
	public SVMNode visitBgt(BgtContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.register2 == null || ctx.namelab == null){
				System.err.println("Error during the execution: in the bgt instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("bgt");
			}
			return new InstructionNode("bgt",ctx.register1.getText(),ctx.register2.getText(),ctx.namelab.getText());
		}
		return new InstructionNode("bgt");
	}

	@Override
	public SVMNode visitBgeq(BgeqContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.register2 == null || ctx.namelab == null){
				System.err.println("Error during the execution: in the bgeq instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("bgeq");
			}
			return new InstructionNode("bgeq",ctx.register1.getText(),ctx.register2.getText(),ctx.namelab.getText());
		}
		return new InstructionNode("bgeq");
	}

	@Override
	public SVMNode visitBleq(BleqContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.register2 == null || ctx.namelab == null){
				System.err.println("Error during the execution: in the bleq instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("bleq");
			}
			return new InstructionNode("bleq",ctx.register1.getText(),ctx.register2.getText(),ctx.namelab.getText());
		}
		return new InstructionNode("bleq");
	}

	@Override
	public SVMNode visitBlt(BltContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.register2 == null || ctx.namelab == null){
				System.err.println("Error during the execution: in the blt instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("blt");
			}
			return new InstructionNode("blt",ctx.register1.getText(),ctx.register2.getText(),ctx.namelab.getText());
		}
		return new InstructionNode("blt");
	}

	@Override
	public SVMNode visitBne(BneContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.register2 == null || ctx.namelab == null){
				System.err.println("Error during the execution: in the bne instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("bne");
			}
			return new InstructionNode("bne",ctx.register1.getText(),ctx.register2.getText(),ctx.namelab.getText());
		}
		return new InstructionNode("bne");
	}

	@Override
	public SVMNode visitAnd(AndContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the and instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("and");
			}
			return new InstructionNode("and",ctx.destination.getText(),ctx.register1.getText(),ctx.register2.getText());
		}
		return new InstructionNode("and");
	}

	@Override
	public SVMNode visitOr(OrContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.register1 == null || ctx.register2 == null){
				System.err.println("Error during the execution: in the or instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("or");
			}
			return new InstructionNode("or",ctx.destination.getText(),ctx.register1.getText(),ctx.register2.getText());
		}
		return new InstructionNode("or");
	}

	@Override
	public SVMNode visitNot(NotContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.src == null){
				System.err.println("Error during the execution: in the not instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("not");
			}
			return new InstructionNode("not",ctx.destination.getText(),ctx.src.getText());
		}
		return new InstructionNode("not");
	}

	@Override
	public SVMNode visitNeg(NegContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null || ctx.src == null){
				System.err.println("Error during the execution: in the neg instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("neg");
			}
			return new InstructionNode("neg",ctx.destination.getText(),ctx.src.getText());
		}
		return new InstructionNode("neg");
	}

	@Override
	public SVMNode visitPrint(PrintContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.src == null){
				System.err.println("Error during the execution: in the print instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("print");
			}
			return new InstructionNode("print",ctx.src.getText());
		}
		return new InstructionNode("print");
	}

	@Override
	public SVMNode visitRet(RetContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.src == null){
				System.err.println("Error during the execution: in the ret instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("ret");
			}
			return new InstructionNode("ret",ctx.src.getText());
		}
		return new InstructionNode("ret");
	}
	
	@Override
	public SVMNode visitBeq(BeqContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.register1 == null || ctx.register2 == null || ctx.namelab == null){
				System.err.println("Error during the execution: in the beq instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("beq");
			}
			return new InstructionNode("beq",ctx.register1.getText(),ctx.register2.getText(),ctx.namelab.getText());
		}
		return new InstructionNode("beq");
	}

	@Override
	public SVMNode visitLabel(LabelContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.namelab == null) {
				System.err.println("Error during the execution: the names of the functions are invalid.");
				thread.interrupt();
				return new InstructionNode("label");
			}
			return new InstructionNode("label",ctx.namelab.getText());
		}
		return new InstructionNode("label");
	}

	@Override
	public SVMNode visitJal(JalContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.namelab == null) {
				System.err.println("Error during the execution: the names of the functions are invalid.");
				thread.interrupt();
				return new InstructionNode("jal");
			}
			return new InstructionNode("jal",ctx.namelab.getText());
		}
		return new InstructionNode("jal");
	}
	
	@Override
	public SVMNode visitBranch(BranchContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.namelab == null) {
				System.err.println("Error during the execution: the names of the functions are invalid.");
				thread.interrupt();
				return new InstructionNode("branch");
			}
			return new InstructionNode("branch",ctx.namelab.getText());
		}
		return new InstructionNode("branch");
	}

	@Override
	public SVMNode visitJr(JrContext ctx) {
		Thread thread = Thread.currentThread();
		if(!thread.isInterrupted()){
			if(ctx.destination == null){
				System.err.println("Error during the execution: in the jr instruction the parameters must not be null.");
				thread.interrupt();
				return new InstructionNode("jr");
			}
			return new InstructionNode("jr",ctx.destination.getText());
		}
		return new InstructionNode("jr");
	}

	@Override
	public SVMNode visitHalt(HaltContext ctx) {
		return new InstructionNode("halt");
	}
}