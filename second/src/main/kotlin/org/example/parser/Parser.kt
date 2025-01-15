package org.example.parser

import java.io.IOException
import java.io.Reader

class Parser(input: Reader) {
    private val lexer = Lexer(input)

    @Throws(IOException::class)
    fun parseD(): Tree {
        nextTokenOfType<Token.Var>()
        val name = nextTokenOfType<Token.Name>()
        nextTokenOfType<Token.Colon>()
        nextTokenOfType<Token.Array>()
        nextTokenOfType<Token.Langle>()
        val typeTree = parseT()
        nextTokenOfType<Token.Rangle>()
        nextTokenOfType<Token.Semicolon>()
        nextTokenOfType<Token.End>()

        return Tree(
            node = "D",
            children = listOf(
                Tree.leaf("var"),
                Tree.leaf(name.name),
                Tree.leaf(":"),
                Tree.leaf("Array"),
                Tree.leaf("<"),
                typeTree,
                Tree.leaf(">"),
                Tree.leaf(";")
            )
        )
    }

    @Throws(IOException::class)
    fun parseT(): Tree {
        val firstToken = lexer.nextToken()

        val children = if (firstToken is Token.Array) {
            nextTokenOfType<Token.Langle>()
            val typeTree = parseT()
            nextTokenOfType<Token.Rangle>()
            listOf(
                Tree.leaf("Array"),
                Tree.leaf("<"),
                typeTree,
                Tree.leaf(">")
            )
        } else {
            val name = requireTokenTypeIs<Token.Name>(firstToken)
            listOf(Tree.leaf(name.name))
        }

        return Tree(
            node = "T",
            children = children
        )
    }

    @Throws(IOException::class)
    private inline fun <reified T : Token> nextTokenOfType(): T {
        val token = lexer.nextToken()
        return requireTokenTypeIs<T>(token)
    }

    private inline fun <reified T : Token> requireTokenTypeIs(token: Token): T {
        if (token !is T) {
            throw ParsingException(unexpectedToken = token, position = lexer.position())
        }
        return token
    }
}
