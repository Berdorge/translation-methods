package org.example.formatter

import org.antlr.v4.runtime.tree.TerminalNode
import org.example.formatter.structure.BracketedExpression
import org.example.formatter.structure.LineTypeMarker
import org.example.formatter.structure.NonWrappedList
import org.example.formatter.structure.StructureItem
import org.example.formatter.structure.StructureItemBlock
import org.example.formatter.structure.StructureItemIndent
import org.example.formatter.structure.StructureItemLine
import org.example.formatter.structure.StructureItemPlain
import org.example.formatter.structure.TernaryOperator
import org.example.formatter.structure.WrappableList

class JavaFormatterVisitor : JavaParserBaseVisitor<StructureItem>() {
    override fun visitPackageDeclaration(ctx: JavaParser.PackageDeclarationContext): StructureItem {
        return NonWrappedList(
            buildList {
                val names = ctx.qualifiedName()
                add(LineTypeMarker(LineType.PACKAGE))
                add(names.first().accept(this@JavaFormatterVisitor))
                for (name in names.subList(1, names.size)) {
                    add(StructureItemPlain(" "))
                    add(name.accept(this@JavaFormatterVisitor))
                }
                add(StructureItemPlain(";"))
                add(StructureItemLine)
            }
        )
    }

    override fun visitImportDeclaration(ctx: JavaParser.ImportDeclarationContext): StructureItem {
        return NonWrappedList(
            buildList {
                val names = ctx.qualifiedName()
                add(LineTypeMarker(LineType.IMPORT))
                add(names.first().accept(this@JavaFormatterVisitor))
                for (name in names.subList(1, names.size)) {
                    add(StructureItemPlain(" "))
                    add(name.accept(this@JavaFormatterVisitor))
                }
                ctx.importWildcard()?.let { wildcard ->
                    add(wildcard.accept(this@JavaFormatterVisitor))
                }
                add(StructureItemPlain(";"))
                add(StructureItemLine)
            }
        )
    }

    override fun visitImportWildcard(ctx: JavaParser.ImportWildcardContext): StructureItem {
        return StructureItemPlain(".*")
    }

    override fun visitTypeDefinition(ctx: JavaParser.TypeDefinitionContext): StructureItem {
        return NonWrappedList(
            listOf(
                LineTypeMarker(LineType.TYPE_DEFINITION),
                StructureItemIndent,
                WrappableList(
                    children = buildList {
                        for (modifier in ctx.modifier()) {
                            add(modifier.accept(this@JavaFormatterVisitor))
                        }
                        add(ctx.IDENTIFIER().accept(this@JavaFormatterVisitor))
                        ctx.extendsDeclaration()?.let { extendsDeclaration ->
                            add(extendsDeclaration.accept(this@JavaFormatterVisitor))
                        }
                        ctx.implementsDeclaration()?.let { implementsDeclaration ->
                            add(implementsDeclaration.accept(this@JavaFormatterVisitor))
                        }
                    },
                    separator = Separator.SPACE
                ),
                StructureItemPlain(" "),
                ctx.block().accept(this)
            )
        )
    }

    override fun visitQualifiedName(ctx: JavaParser.QualifiedNameContext): StructureItem {
        return WrappableList(
            children = ctx.IDENTIFIER().map { identifier ->
                identifier.accept(this)
            },
            separator = Separator.MEMBER_ACCESS
        )
    }

    override fun visitExtendsDeclaration(ctx: JavaParser.ExtendsDeclarationContext): StructureItem {
        return WrappableList(
            children = listOf(
                StructureItemPlain("extends"),
                ctx.type().accept(this)
            ),
            separator = Separator.SPACE
        )
    }

    override fun visitImplementsDeclaration(ctx: JavaParser.ImplementsDeclarationContext): StructureItem {
        val types = ctx.typeList().type()
        return WrappableList(
            children = buildList {
                add(StructureItemPlain("implements"))
                for (type in types.subList(0, types.size - 1)) {
                    add(
                        NonWrappedList(
                            listOf(
                                type.accept(this@JavaFormatterVisitor),
                                StructureItemPlain(",")
                            )
                        )
                    )
                }
                add(types.last().accept(this@JavaFormatterVisitor))
            },
            separator = Separator.SPACE
        )
    }

    override fun visitMethodDefinition(ctx: JavaParser.MethodDefinitionContext): StructureItem {
        return NonWrappedList(
            listOf(
                LineTypeMarker(LineType.METHOD),
                StructureItemIndent,
                WrappableList(
                    children = buildList {
                        for (modifier in ctx.modifier()) {
                            add(modifier.accept(this@JavaFormatterVisitor))
                        }
                        ctx.type()?.let { type ->
                            add(type.accept(this@JavaFormatterVisitor))
                        }
                        add(ctx.IDENTIFIER().accept(this@JavaFormatterVisitor))
                    },
                    separator = Separator.SPACE
                ),
                ctx.parameters().accept(this),
                ctx.methodBody().accept(this)
            )
        )
    }

    override fun visitParameters(ctx: JavaParser.ParametersContext): StructureItem {
        return BracketedExpression(
            startBracket = "(",
            middle = visitChildren(ctx),
            endBracket = ")"
        )
    }

    override fun visitParameterList(ctx: JavaParser.ParameterListContext): StructureItem {
        return WrappableList(
            children = ctx.parameter().map { parameter ->
                parameter.accept(this)
            },
            separator = Separator.comma()
        )
    }

    override fun visitParameter(ctx: JavaParser.ParameterContext): StructureItem {
        return WrappableList(
            children = ctx.modifier()
                .map { modifier ->
                    modifier.accept(this)
                }
                .plus(ctx.type().accept(this))
                .plus(ctx.variableDefinition().accept(this)),
            separator = Separator.SPACE
        )
    }

    override fun visitMethodBody(ctx: JavaParser.MethodBodyContext): StructureItem {
        return NonWrappedList(
            if (ctx.block() == null) {
                listOf(StructureItemPlain(";"), StructureItemLine)
            } else {
                listOf(StructureItemPlain(" "), visitBlock(ctx.block()))
            }
        )
    }

    override fun visitVariablesDefinition(ctx: JavaParser.VariablesDefinitionContext): StructureItem {
        return WrappableList(
            children = ctx.modifier()
                .map { modifier ->
                    modifier.accept(this)
                }
                .plus(ctx.type().accept(this))
                .plus(ctx.variableDefinitionList().accept(this)),
            separator = Separator.SPACE
        )
    }

    override fun visitVariableDefinitionList(ctx: JavaParser.VariableDefinitionListContext): StructureItem {
        return WrappableList(
            children = ctx.variableDefinition().map { definition ->
                definition.accept(this)
            },
            separator = Separator.comma()
        )
    }

    override fun visitVariableDefinition(ctx: JavaParser.VariableDefinitionContext): StructureItem {
        return WrappableList(
            children = buildList {
                add(ctx.IDENTIFIER().accept(this@JavaFormatterVisitor))
                ctx.variableInitializer()?.let { initializer ->
                    add(initializer.accept(this@JavaFormatterVisitor))
                }
            },
            separator = Separator.ASSIGNMENT
        )
    }

    override fun visitArrayInitializer(ctx: JavaParser.ArrayInitializerContext): StructureItem {
        return BracketedExpression(
            startBracket = "{",
            middle = WrappableList(
                children = ctx.variableInitializer().map { initializer ->
                    initializer.accept(this)
                },
                separator = Separator.comma()
            ),
            endBracket = "}"
        )
    }

    override fun visitBlock(ctx: JavaParser.BlockContext): StructureItem {
        return visitBlock(block = ctx, addLastNewline = true)
    }

    override fun visitBlockStatement(ctx: JavaParser.BlockStatementContext): StructureItem {
        return if (ctx.variablesDefinition() == null) {
            super.visitBlockStatement(ctx)
        } else {
            NonWrappedList(
                listOf(
                    LineTypeMarker(LineType.STATEMENT),
                    StructureItemIndent,
                    visitChildren(ctx),
                    StructureItemLine
                )
            )
        }
    }

    override fun visitStatementBlock(ctx: JavaParser.StatementBlockContext): StructureItem {
        return NonWrappedList(
            listOf(
                LineTypeMarker(LineType.BLOCK),
                StructureItemIndent,
                ctx.block().accept(this)
            )
        )
    }

    override fun visitStatementIf(ctx: JavaParser.StatementIfContext): StructureItem {
        return NonWrappedList(
            buildList {
                add(LineTypeMarker(LineType.STATEMENT))
                add(StructureItemIndent)
                add(StructureItemPlain("if "))
                add(ctx.parenthesisedExpression().accept(this@JavaFormatterVisitor))
                add(StructureItemPlain(" "))
                add(acceptStatementAsBlock(statement = ctx.statement(0), addLastNewline = false))
                if (ctx.ELSE() != null) {
                    val elseStatement = ctx.statement(1)
                    add(StructureItemPlain(" else "))
                    if (elseStatement is JavaParser.StatementIfContext) {
                        add(elseStatement.accept(this@JavaFormatterVisitor))
                    } else {
                        add(
                            acceptStatementAsBlock(
                                statement = elseStatement,
                                addLastNewline = false
                            )
                        )
                    }
                }
                add(StructureItemLine)
            }
        )
    }

    override fun visitStatementFor(ctx: JavaParser.StatementForContext): StructureItem {
        return NonWrappedList(
            listOf(
                LineTypeMarker(LineType.STATEMENT),
                StructureItemIndent,
                StructureItemPlain("for "),
                BracketedExpression(
                    startBracket = "(",
                    middle = ctx.forConditions().accept(this),
                    endBracket = ")"
                ),
                StructureItemPlain(" "),
                acceptStatementAsBlock(statement = ctx.statement(), addLastNewline = true)
            )
        )
    }

    override fun visitForConditions(ctx: JavaParser.ForConditionsContext): StructureItem {
        val init = if (ctx.forInit() == null) {
            StructureItem.EMPTY
        } else {
            visitForInit(ctx.forInit())
        }
        val condition = if (ctx.expression() == null) {
            StructureItem.EMPTY
        } else {
            ctx.expression().accept(this)
        }
        val update = if (ctx.expressionList() == null) {
            StructureItem.EMPTY
        } else {
            visitExpressionList(ctx.expressionList())
        }
        return WrappableList(
            children = listOf(
                init,
                condition,
                update
            ),
            separator = Separator.comma(";")
        )
    }

    override fun visitStatementDo(ctx: JavaParser.StatementDoContext): StructureItem {
        return NonWrappedList(
            listOf(
                LineTypeMarker(LineType.STATEMENT),
                StructureItemIndent,
                StructureItemPlain("do "),
                acceptStatementAsBlock(statement = ctx.statement(), addLastNewline = false),
                StructureItemPlain(" while "),
                ctx.parenthesisedExpression().accept(this),
                StructureItemPlain(";"),
                StructureItemLine
            )
        )
    }

    override fun visitStatementTry(ctx: JavaParser.StatementTryContext): StructureItem {
        val catchAndFinallyClauses = ctx.children.subList(2, ctx.childCount).map { child ->
            child.accept(this)
        }
        return NonWrappedList(
            listOf(
                LineTypeMarker(LineType.STATEMENT),
                StructureItemIndent,
                StructureItemPlain("try "),
                visitBlock(block = ctx.block(), addLastNewline = false)
            )
                .plus(catchAndFinallyClauses)
                .plus(StructureItemLine)
        )
    }

    override fun visitCatchClause(ctx: JavaParser.CatchClauseContext): StructureItem {
        return NonWrappedList(
            children = listOf(
                StructureItemPlain(" catch"),
                BracketedExpression(
                    startBracket = "(",
                    middle = WrappableList(
                        children = ctx.modifier()
                            .map { modifier ->
                                modifier.accept(this)
                            }
                            .plus(ctx.catchType().accept(this))
                            .plus(ctx.IDENTIFIER().accept(this)),
                        separator = Separator.SPACE
                    ),
                    endBracket = ")"
                ),
                visitBlock(block = ctx.block(), addLastNewline = false)
            ),
            separator = " "
        )
    }

    override fun visitCatchType(ctx: JavaParser.CatchTypeContext): StructureItem {
        return WrappableList(
            children = ctx.qualifiedName().map { name ->
                visitQualifiedName(name)
            },
            separator = Separator.binaryOperator("|")
        )
    }

    override fun visitFinallyBlock(ctx: JavaParser.FinallyBlockContext): StructureItem {
        return NonWrappedList(
            children = listOf(
                StructureItemPlain(" finally"),
                visitBlock(block = ctx.block(), addLastNewline = false)
            ),
            separator = " "
        )
    }

    override fun visitStatementExpressionOperator(
        ctx: JavaParser.StatementExpressionOperatorContext
    ): StructureItem {
        return NonWrappedList(
            buildList {
                add(LineTypeMarker(LineType.STATEMENT))
                add(StructureItemIndent)
                add(ctx.IDENTIFIER().accept(this@JavaFormatterVisitor))
                ctx.expression()?.let { expression ->
                    add(StructureItemPlain(" "))
                    add(expression.accept(this@JavaFormatterVisitor))
                }
                add(StructureItemPlain(";"))
                add(StructureItemLine)
            }
        )
    }

    override fun visitStatementExpression(
        ctx: JavaParser.StatementExpressionContext
    ): StructureItem {
        return NonWrappedList(
            listOf(
                LineTypeMarker(LineType.STATEMENT),
                StructureItemIndent,
                ctx.expression().accept(this),
                StructureItemPlain(";"),
                StructureItemLine
            )
        )
    }

    override fun visitParenthesisedExpression(ctx: JavaParser.ParenthesisedExpressionContext): StructureItem {
        return BracketedExpression(
            startBracket = "(",
            middle = visitChildren(ctx),
            endBracket = ")"
        )
    }

    override fun visitSquareBracketExpression(ctx: JavaParser.SquareBracketExpressionContext): StructureItem {
        return NonWrappedList(
            listOf(
                ctx.expression(0).accept(this),
                BracketedExpression(
                    startBracket = "[",
                    middle = ctx.expression(1).accept(this),
                    endBracket = "]"
                )
            )
        )
    }

    override fun visitMemberReferenceExpression(
        ctx: JavaParser.MemberReferenceExpressionContext
    ): StructureItem {
        return WrappableList(
            children = listOf(
                ctx.expression().accept(this),
                ctx.memberReference().accept(this)
            ),
            separator = Separator.MEMBER_ACCESS
        )
    }

    override fun visitMethodCall(ctx: JavaParser.MethodCallContext): StructureItem {
        return NonWrappedList(
            listOf(
                ctx.IDENTIFIER().accept(this),
                ctx.arguments().accept(this)
            )
        )
    }

    override fun visitArguments(ctx: JavaParser.ArgumentsContext): StructureItem {
        return BracketedExpression(
            startBracket = "(",
            middle = visitChildren(ctx),
            endBracket = ")"
        )
    }

    override fun visitPostfixOperatorExpression(
        ctx: JavaParser.PostfixOperatorExpressionContext
    ): StructureItem {
        return NonWrappedList(
            listOf(
                visitChildren(ctx),
                StructureItemPlain(ctx.postfix.text)
            )
        )
    }

    override fun visitUnaryOperatorExpression(ctx: JavaParser.UnaryOperatorExpressionContext): StructureItem {
        return NonWrappedList(
            listOf(
                StructureItemPlain(ctx.prefix.text),
                visitChildren(ctx)
            )
        )
    }

    override fun visitCastExpression(ctx: JavaParser.CastExpressionContext): StructureItem {
        return NonWrappedList(
            children = listOf(
                BracketedExpression(
                    startBracket = "(",
                    middle = ctx.type().accept(this),
                    endBracket = ")"
                ),
                ctx.expression().accept(this)
            ),
            separator = " "
        )
    }

    override fun visitObjectCreationExpression(
        ctx: JavaParser.ObjectCreationExpressionContext
    ): StructureItem {
        return WrappableList(
            children = listOf(
                StructureItemPlain("new"),
                ctx.constructorInvocation().accept(this)
            ),
            separator = Separator.SPACE
        )
    }

    override fun visitBinaryOperatorExpression(
        ctx: JavaParser.BinaryOperatorExpressionContext
    ): StructureItem {
        val operator = if (ctx.shiftOperator() == null) {
            ctx.bop.text
        } else {
            ctx.shiftOperator().text
        }
        return WrappableList(
            children = listOf(
                ctx.expression(0).accept(this),
                ctx.expression(1).accept(this)
            ),
            separator = Separator.binaryOperator(operator)
        )
    }

    override fun visitInstanceOfOperatorExpression(
        ctx: JavaParser.InstanceOfOperatorExpressionContext
    ): StructureItem {
        return WrappableList(
            children = listOf(
                StructureItemPlain("instanceof"),
                ctx.expression().accept(this)
            ),
            separator = Separator.SPACE
        )
    }

    override fun visitTernaryExpression(
        ctx: JavaParser.TernaryExpressionContext
    ): StructureItem {
        return TernaryOperator(
            left = ctx.expression(0).accept(this),
            middle = ctx.expression(1).accept(this),
            right = ctx.expression(2).accept(this),
            leftMiddleSeparator = Separator.binaryOperator("?"),
            middleRightSeparator = Separator.binaryOperator(":")
        )
    }

    override fun visitAssignmentExpression(
        ctx: JavaParser.AssignmentExpressionContext
    ): StructureItem {
        return WrappableList(
            children = listOf(
                ctx.expression(0).accept(this),
                ctx.expression(1).accept(this)
            ),
            separator = Separator.ASSIGNMENT
        )
    }

    override fun visitLiteral(ctx: JavaParser.LiteralContext): StructureItem {
        return StructureItemPlain(ctx.text)
    }

    override fun visitTerminal(node: TerminalNode): StructureItem {
        return if (node.symbol.type in outputTerminalTypes) {
            StructureItemPlain(node.text)
        } else {
            StructureItem.EMPTY
        }
    }

    override fun defaultResult() = StructureItem.EMPTY

    override fun aggregateResult(
        aggregate: StructureItem,
        nextResult: StructureItem
    ) = when {
        aggregate === StructureItem.EMPTY -> nextResult
        nextResult === StructureItem.EMPTY -> aggregate
        else -> NonWrappedList(listOf(aggregate, nextResult))
    }

    private fun visitBlock(block: JavaParser.BlockContext, addLastNewline: Boolean): StructureItem {
        return StructureItemBlock(
            child = visitChildren(block),
            addLastNewline = addLastNewline
        )
    }

    private fun acceptStatementAsBlock(
        statement: JavaParser.StatementContext,
        addLastNewline: Boolean
    ): StructureItem {
        return if (statement is JavaParser.StatementBlockContext) {
            visitBlock(block = statement.block(), addLastNewline = addLastNewline)
        } else {
            StructureItemBlock(
                child = statement.accept(this),
                addLastNewline = addLastNewline
            )
        }
    }

    companion object {
        val outputTerminalTypes = setOf(
            JavaLexer.SEMICOLON,
            JavaLexer.IDENTIFIER,
            JavaLexer.LBRACKET,
            JavaLexer.RBRACKET
        )
    }
}
