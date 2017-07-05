// Generated from src/parser/Query.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(QueryParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#relation_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_name(QueryParser.Relation_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(QueryParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#atomic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic_expr(QueryParser.Atomic_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(QueryParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(QueryParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(QueryParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(QueryParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(QueryParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(QueryParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#attribute_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_name(QueryParser.Attribute_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(QueryParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(QueryParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#attribute_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_list(QueryParser.Attribute_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#renaming}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenaming(QueryParser.RenamingContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(QueryParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#difference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(QueryParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(QueryParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#natural_join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatural_join(QueryParser.Natural_joinContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(QueryParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#open_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_cmd(QueryParser.Open_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#close_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClose_cmd(QueryParser.Close_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#write_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_cmd(QueryParser.Write_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#exit_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_cmd(QueryParser.Exit_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#show_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_cmd(QueryParser.Show_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#create_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_cmd(QueryParser.Create_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#update_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_cmd(QueryParser.Update_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#insert_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_cmd(QueryParser.Insert_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#delete_cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_cmd(QueryParser.Delete_cmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#typed_attribute_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyped_attribute_list(QueryParser.Typed_attribute_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(QueryParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(QueryParser.ProgramContext ctx);
}