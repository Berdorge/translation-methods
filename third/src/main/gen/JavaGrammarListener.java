// Generated from /home/shosha/Projects/haskell/translation-methods/third/src/main/antlr/JavaParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaGrammar}.
 */
public interface JavaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(JavaGrammar.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(JavaGrammar.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(JavaGrammar.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(JavaGrammar.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(JavaGrammar.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(JavaGrammar.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#importWildcard}.
	 * @param ctx the parse tree
	 */
	void enterImportWildcard(JavaGrammar.ImportWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#importWildcard}.
	 * @param ctx the parse tree
	 */
	void exitImportWildcard(JavaGrammar.ImportWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(JavaGrammar.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(JavaGrammar.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#extendsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExtendsDeclaration(JavaGrammar.ExtendsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#extendsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExtendsDeclaration(JavaGrammar.ExtendsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#implementsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImplementsDeclaration(JavaGrammar.ImplementsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#implementsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImplementsDeclaration(JavaGrammar.ImplementsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(JavaGrammar.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(JavaGrammar.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#typeBody}.
	 * @param ctx the parse tree
	 */
	void enterTypeBody(JavaGrammar.TypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#typeBody}.
	 * @param ctx the parse tree
	 */
	void exitTypeBody(JavaGrammar.TypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#typeBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeBodyDeclaration(JavaGrammar.TypeBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#typeBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeBodyDeclaration(JavaGrammar.TypeBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JavaGrammar.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JavaGrammar.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JavaGrammar.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JavaGrammar.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JavaGrammar.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JavaGrammar.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(JavaGrammar.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(JavaGrammar.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(JavaGrammar.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(JavaGrammar.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(JavaGrammar.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(JavaGrammar.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(JavaGrammar.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(JavaGrammar.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(JavaGrammar.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(JavaGrammar.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(JavaGrammar.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(JavaGrammar.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JavaGrammar.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JavaGrammar.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JavaGrammar.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JavaGrammar.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(JavaGrammar.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(JavaGrammar.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JavaGrammar.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JavaGrammar.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(JavaGrammar.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(JavaGrammar.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(JavaGrammar.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(JavaGrammar.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JavaGrammar.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JavaGrammar.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(JavaGrammar.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(JavaGrammar.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(JavaGrammar.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(JavaGrammar.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JavaGrammar.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JavaGrammar.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(JavaGrammar.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(JavaGrammar.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementIf(JavaGrammar.StatementIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementIf(JavaGrammar.StatementIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementFor(JavaGrammar.StatementForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementFor(JavaGrammar.StatementForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementDo}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDo(JavaGrammar.StatementDoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementDo}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDo(JavaGrammar.StatementDoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementTry}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementTry(JavaGrammar.StatementTryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementTry}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementTry(JavaGrammar.StatementTryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(JavaGrammar.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(JavaGrammar.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementExpressionOperator}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionOperator(JavaGrammar.StatementExpressionOperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementExpressionOperator}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionOperator(JavaGrammar.StatementExpressionOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementNop}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementNop(JavaGrammar.StatementNopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementNop}
	 * labeled alternative in {@link JavaGrammar#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementNop(JavaGrammar.StatementNopContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(JavaGrammar.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(JavaGrammar.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(JavaGrammar.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(JavaGrammar.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(JavaGrammar.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(JavaGrammar.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(JavaGrammar.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(JavaGrammar.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(JavaGrammar.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(JavaGrammar.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#parenthesisedExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisedExpression(JavaGrammar.ParenthesisedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#parenthesisedExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisedExpression(JavaGrammar.ParenthesisedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(JavaGrammar.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(JavaGrammar.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(JavaGrammar.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(JavaGrammar.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOperatorExpression(JavaGrammar.PostfixOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOperatorExpression(JavaGrammar.PostfixOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(JavaGrammar.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(JavaGrammar.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberReferenceExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberReferenceExpression(JavaGrammar.MemberReferenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberReferenceExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberReferenceExpression(JavaGrammar.MemberReferenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperatorExpression(JavaGrammar.BinaryOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperatorExpression(JavaGrammar.BinaryOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstanceOfOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterInstanceOfOperatorExpression(JavaGrammar.InstanceOfOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstanceOfOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitInstanceOfOperatorExpression(JavaGrammar.InstanceOfOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperatorExpression(JavaGrammar.UnaryOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOperatorExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperatorExpression(JavaGrammar.UnaryOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(JavaGrammar.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(JavaGrammar.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodCallExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpression(JavaGrammar.MethodCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodCallExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpression(JavaGrammar.MethodCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectCreationExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjectCreationExpression(JavaGrammar.ObjectCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectCreationExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjectCreationExpression(JavaGrammar.ObjectCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(JavaGrammar.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(JavaGrammar.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SquareBracketExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterSquareBracketExpression(JavaGrammar.SquareBracketExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SquareBracketExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitSquareBracketExpression(JavaGrammar.SquareBracketExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CastExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(JavaGrammar.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CastExpression}
	 * labeled alternative in {@link JavaGrammar#expression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(JavaGrammar.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JavaGrammar.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JavaGrammar.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#memberReference}.
	 * @param ctx the parse tree
	 */
	void enterMemberReference(JavaGrammar.MemberReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#memberReference}.
	 * @param ctx the parse tree
	 */
	void exitMemberReference(JavaGrammar.MemberReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void enterShiftOperator(JavaGrammar.ShiftOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void exitShiftOperator(JavaGrammar.ShiftOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#constructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterConstructorInvocation(JavaGrammar.ConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#constructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitConstructorInvocation(JavaGrammar.ConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(JavaGrammar.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(JavaGrammar.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(JavaGrammar.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(JavaGrammar.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(JavaGrammar.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(JavaGrammar.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JavaGrammar.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JavaGrammar.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammar#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(JavaGrammar.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammar#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(JavaGrammar.ArgumentsContext ctx);
}