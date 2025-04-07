// Generated from SVM.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SVMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SVMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SVMParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(@NotNull SVMParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull SVMParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#addi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddi(@NotNull SVMParser.AddiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#jr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJr(@NotNull SVMParser.JrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#lw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLw(@NotNull SVMParser.LwContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(@NotNull SVMParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#bgt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBgt(@NotNull SVMParser.BgtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#sb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSb(@NotNull SVMParser.SbContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#multi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti(@NotNull SVMParser.MultiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#beq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeq(@NotNull SVMParser.BeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#pop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPop(@NotNull SVMParser.PopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(@NotNull SVMParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(@NotNull SVMParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull SVMParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#top}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop(@NotNull SVMParser.TopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#jal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJal(@NotNull SVMParser.JalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull SVMParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#divi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivi(@NotNull SVMParser.DiviContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssembly(@NotNull SVMParser.AssemblyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#bleq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBleq(@NotNull SVMParser.BleqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#bne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBne(@NotNull SVMParser.BneContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#subi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubi(@NotNull SVMParser.SubiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#bgeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBgeq(@NotNull SVMParser.BgeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull SVMParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(@NotNull SVMParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#move}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMove(@NotNull SVMParser.MoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull SVMParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#sw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSw(@NotNull SVMParser.SwContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#blt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlt(@NotNull SVMParser.BltContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(@NotNull SVMParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#push}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPush(@NotNull SVMParser.PushContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#halt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalt(@NotNull SVMParser.HaltContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull SVMParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(@NotNull SVMParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#lb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLb(@NotNull SVMParser.LbContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#li}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLi(@NotNull SVMParser.LiContext ctx);
}