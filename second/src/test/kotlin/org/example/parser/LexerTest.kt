package org.example.parser

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.io.StringReader

class LexerTest : DescribeSpec({
    describe("single tokens") {
        it("var token") {
            extractToken("var") shouldBe Token.Var
        }

        it("array token") {
            extractToken("Array") shouldBe Token.Array
        }

        it("name token") {
            extractToken("x") shouldBe Token.Name("x")
        }

        it("colon token") {
            extractToken(":") shouldBe Token.Colon
        }

        it("langle token") {
            extractToken("<") shouldBe Token.Langle
        }

        it("rangle token") {
            extractToken(">") shouldBe Token.Rangle
        }

        it("semicolon token") {
            extractToken(";") shouldBe Token.Semicolon
        }

        it("end token") {
            extractToken("") shouldBe Token.End
        }
    }

    describe("sophisticated names") {
        it("multiletter name") {
            extractToken("xyz") shouldBe Token.Name("xyz")
        }

        it("name beginning with var") {
            extractToken("variable") shouldBe Token.Name("variable")
        }

        it("name beginning with Array") {
            extractToken("Arrayname") shouldBe Token.Name("Arrayname")
        }

        it("name containing var") {
            extractToken("somevariable") shouldBe Token.Name("somevariable")
        }

        it("name ending with var") {
            extractToken("somevar") shouldBe Token.Name("somevar")
        }

        it("name can't start with var") {
            val exception = shouldThrow<LexingException> {
                extractToken("1var")
            }
            exception.position shouldBe 0
            exception.unexpectedCharacter shouldBe '1'
        }

        it("name can contain numeric chars after the first char") {
            extractToken("x1234567890") shouldBe Token.Name("x1234567890")
        }

        it("cases of letters in a name can be mixed") {
            extractToken("hElLoW0RlD") shouldBe Token.Name("hElLoW0RlD")
        }
    }

    describe("token sequences tests") {
        it("expected grammar") {
            extractTokens("var x: Array<Int>;") shouldBe listOf(
                Token.Var,
                Token.Name("x"),
                Token.Colon,
                Token.Array,
                Token.Langle,
                Token.Name("Int"),
                Token.Rangle,
                Token.Semicolon,
                Token.End
            )
        }

        it("non-mandatory spaces are ignored") {
            extractTokens("  var  x  :  Array  <  Array  <  Int  >  >  ;  ") shouldBe listOf(
                Token.Var,
                Token.Name("x"),
                Token.Colon,
                Token.Array,
                Token.Langle,
                Token.Array,
                Token.Langle,
                Token.Name("Int"),
                Token.Rangle,
                Token.Rangle,
                Token.Semicolon,
                Token.End
            )
        }
    }
})

private fun extractToken(input: String): Token {
    val lexer = Lexer(StringReader(input))
    return lexer.nextToken()
}

private fun extractTokens(input: String): List<Token> {
    val lexer = Lexer(StringReader(input))
    return buildList {
        var token: Token
        do {
            token = lexer.nextToken()
            add(token)
        } while (token != Token.End)
    }
}
