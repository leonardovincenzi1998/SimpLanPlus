// Generated from SimpLanPlus.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpLanPlusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpLanPlusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(@NotNull SimpLanPlusParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseExp(@NotNull SimpLanPlusParser.BaseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinExp(@NotNull SimpLanPlusParser.BinExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code derExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerExp(@NotNull SimpLanPlusParser.DerExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull SimpLanPlusParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#decVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecVar(@NotNull SimpLanPlusParser.DecVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExp(@NotNull SimpLanPlusParser.BoolExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull SimpLanPlusParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull SimpLanPlusParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExp(@NotNull SimpLanPlusParser.CallExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull SimpLanPlusParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExp(@NotNull SimpLanPlusParser.NotExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull SimpLanPlusParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull SimpLanPlusParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(@NotNull SimpLanPlusParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull SimpLanPlusParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValExp(@NotNull SimpLanPlusParser.ValExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExp(@NotNull SimpLanPlusParser.NegExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull SimpLanPlusParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#ite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIte(@NotNull SimpLanPlusParser.IteContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#decFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecFun(@NotNull SimpLanPlusParser.DecFunContext ctx);
}