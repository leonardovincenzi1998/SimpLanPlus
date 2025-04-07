// Generated from SVM.g4 by ANTLR 4.7.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SVMParser}.
 */
public interface SVMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAssembly(SVMParser.AssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAssembly(SVMParser.AssemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(SVMParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(SVMParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#push}.
	 * @param ctx the parse tree
	 */
	void enterPush(SVMParser.PushContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#push}.
	 * @param ctx the parse tree
	 */
	void exitPush(SVMParser.PushContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#pop}.
	 * @param ctx the parse tree
	 */
	void enterPop(SVMParser.PopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#pop}.
	 * @param ctx the parse tree
	 */
	void exitPop(SVMParser.PopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#top}.
	 * @param ctx the parse tree
	 */
	void enterTop(SVMParser.TopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#top}.
	 * @param ctx the parse tree
	 */
	void exitTop(SVMParser.TopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#li}.
	 * @param ctx the parse tree
	 */
	void enterLi(SVMParser.LiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#li}.
	 * @param ctx the parse tree
	 */
	void exitLi(SVMParser.LiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMove(SVMParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMove(SVMParser.MoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#lw}.
	 * @param ctx the parse tree
	 */
	void enterLw(SVMParser.LwContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#lw}.
	 * @param ctx the parse tree
	 */
	void exitLw(SVMParser.LwContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#sw}.
	 * @param ctx the parse tree
	 */
	void enterSw(SVMParser.SwContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#sw}.
	 * @param ctx the parse tree
	 */
	void exitSw(SVMParser.SwContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#lb}.
	 * @param ctx the parse tree
	 */
	void enterLb(SVMParser.LbContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#lb}.
	 * @param ctx the parse tree
	 */
	void exitLb(SVMParser.LbContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#sb}.
	 * @param ctx the parse tree
	 */
	void enterSb(SVMParser.SbContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#sb}.
	 * @param ctx the parse tree
	 */
	void exitSb(SVMParser.SbContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(SVMParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(SVMParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#addi}.
	 * @param ctx the parse tree
	 */
	void enterAddi(SVMParser.AddiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#addi}.
	 * @param ctx the parse tree
	 */
	void exitAddi(SVMParser.AddiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(SVMParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(SVMParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#subi}.
	 * @param ctx the parse tree
	 */
	void enterSubi(SVMParser.SubiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#subi}.
	 * @param ctx the parse tree
	 */
	void exitSubi(SVMParser.SubiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(SVMParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(SVMParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#multi}.
	 * @param ctx the parse tree
	 */
	void enterMulti(SVMParser.MultiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#multi}.
	 * @param ctx the parse tree
	 */
	void exitMulti(SVMParser.MultiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(SVMParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(SVMParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#divi}.
	 * @param ctx the parse tree
	 */
	void enterDivi(SVMParser.DiviContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#divi}.
	 * @param ctx the parse tree
	 */
	void exitDivi(SVMParser.DiviContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#bgt}.
	 * @param ctx the parse tree
	 */
	void enterBgt(SVMParser.BgtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#bgt}.
	 * @param ctx the parse tree
	 */
	void exitBgt(SVMParser.BgtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#bgeq}.
	 * @param ctx the parse tree
	 */
	void enterBgeq(SVMParser.BgeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#bgeq}.
	 * @param ctx the parse tree
	 */
	void exitBgeq(SVMParser.BgeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#bleq}.
	 * @param ctx the parse tree
	 */
	void enterBleq(SVMParser.BleqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#bleq}.
	 * @param ctx the parse tree
	 */
	void exitBleq(SVMParser.BleqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#blt}.
	 * @param ctx the parse tree
	 */
	void enterBlt(SVMParser.BltContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#blt}.
	 * @param ctx the parse tree
	 */
	void exitBlt(SVMParser.BltContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#bne}.
	 * @param ctx the parse tree
	 */
	void enterBne(SVMParser.BneContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#bne}.
	 * @param ctx the parse tree
	 */
	void exitBne(SVMParser.BneContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SVMParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SVMParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(SVMParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(SVMParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(SVMParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(SVMParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(SVMParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(SVMParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SVMParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SVMParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(SVMParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(SVMParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#beq}.
	 * @param ctx the parse tree
	 */
	void enterBeq(SVMParser.BeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#beq}.
	 * @param ctx the parse tree
	 */
	void exitBeq(SVMParser.BeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(SVMParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(SVMParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#jal}.
	 * @param ctx the parse tree
	 */
	void enterJal(SVMParser.JalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#jal}.
	 * @param ctx the parse tree
	 */
	void exitJal(SVMParser.JalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#jr}.
	 * @param ctx the parse tree
	 */
	void enterJr(SVMParser.JrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#jr}.
	 * @param ctx the parse tree
	 */
	void exitJr(SVMParser.JrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#halt}.
	 * @param ctx the parse tree
	 */
	void enterHalt(SVMParser.HaltContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#halt}.
	 * @param ctx the parse tree
	 */
	void exitHalt(SVMParser.HaltContext ctx);
}