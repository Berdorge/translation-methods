// Generated from /home/shosha/Projects/haskell/translation-methods/third/src/main/antlr/JavaParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaGrammar}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(JavaGrammar.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(JavaGrammar.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(JavaGrammar.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#importWildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportWildcard(JavaGrammar.ImportWildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(JavaGrammar.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#extendsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsDeclaration(JavaGrammar.ExtendsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#implementsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplementsDeclaration(JavaGrammar.ImplementsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(JavaGrammar.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#typeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBody(JavaGrammar.TypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#typeBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBodyDeclaration(JavaGrammar.TypeBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JavaGrammar.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JavaGrammar.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JavaGrammar.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(JavaGrammar.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(JavaGrammar.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(JavaGrammar.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(JavaGrammar.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(JavaGrammar.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(JavaGrammar.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JavaGrammar.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JavaGrammar.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(JavaGrammar.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JavaGrammar.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(JavaGrammar.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(JavaGrammar.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JavaGrammar.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JavaGrammar.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(JavaGrammar.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JavaGrammar.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(JavaGrammar.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(JavaGrammar.StatementIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementFor(JavaGrammar.StatementForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementDo}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDo(JavaGrammar.StatementDoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementTry}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTry(JavaGrammar.StatementTryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JavaGrammar.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpressionOperator}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionOperator(JavaGrammar.StatementExpressionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementNop}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNop(JavaGrammar.StatementNopContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(JavaGrammar.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(JavaGrammar.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(JavaGrammar.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(JavaGrammar.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(JavaGrammar.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#parenthesisedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisedExpression(JavaGrammar.ParenthesisedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(JavaGrammar.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(JavaGrammar.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperatorExpression(JavaGrammar.PostfixOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(JavaGrammar.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberReferenceExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberReferenceExpression(JavaGrammar.MemberReferenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperatorExpression(JavaGrammar.BinaryOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstanceOfOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceOfOperatorExpression(JavaGrammar.InstanceOfOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperatorExpression(JavaGrammar.UnaryOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(JavaGrammar.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodCallExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallExpression(JavaGrammar.MethodCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectCreationExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCreationExpression(JavaGrammar.ObjectCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JavaGrammar.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SquareBracketExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareBracketExpression(JavaGrammar.SquareBracketExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CastExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(JavaGrammar.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JavaGrammar.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#memberReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberReference(JavaGrammar.MemberReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#shiftOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOperator(JavaGrammar.ShiftOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#constructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorInvocation(JavaGrammar.ConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(JavaGrammar.ArrayCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#classCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreatorRest(JavaGrammar.ClassCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(JavaGrammar.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JavaGrammar.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammar#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(JavaGrammar.ArgumentsContext ctx);
}