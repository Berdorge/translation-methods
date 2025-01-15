package org.example.parser

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.io.StringReader

class ParserTest : DescribeSpec({
    it("production rule D -> var name: Array<T>;") {
        parseD("var x: Array<Int>;") shouldBe Tree(
            node = "D",
            children = listOf(
                Tree.leaf("var"),
                Tree.leaf("x"),
                Tree.leaf(":"),
                Tree.leaf("Array"),
                Tree.leaf("<"),
                Tree(
                    node = "T",
                    children = listOf(Tree.leaf("Int"))
                ),
                Tree.leaf(">"),
                Tree.leaf(";")
            )
        )
    }

    it("production rule T -> name") {
        parseT("Int") shouldBe Tree(
            node = "T",
            children = listOf(Tree.leaf("Int"))
        )
    }

    it("production rule T -> Array<T>") {
        parseT("Array<Int>") shouldBe Tree(
            node = "T",
            children = listOf(
                Tree.leaf("Array"),
                Tree.leaf("<"),
                Tree(
                    node = "T",
                    children = listOf(Tree.leaf("Int"))
                ),
                Tree.leaf(">")
            )
        )
    }

    it("nested arrays") {
        parseD("var x: Array<Array<Int>>;") shouldBe Tree(
            node = "D",
            children = listOf(
                Tree.leaf("var"),
                Tree.leaf("x"),
                Tree.leaf(":"),
                Tree.leaf("Array"),
                Tree.leaf("<"),
                Tree(
                    node = "T",
                    children = listOf(
                        Tree.leaf("Array"),
                        Tree.leaf("<"),
                        Tree(
                            node = "T",
                            children = listOf(Tree.leaf("Int"))
                        ),
                        Tree.leaf(">")
                    )
                ),
                Tree.leaf(">"),
                Tree.leaf(";")
            )
        )
    }

    describe("missed token errors") {
        it("no var token") {
            val exception = shouldThrow<ParsingException> {
                parseD("x: Array<Int>;")
            }
            exception.position shouldBe 1
            exception.unexpectedToken shouldBe Token.Name("x")
        }

        it("no name token") {
            val exception = shouldThrow<ParsingException> {
                parseD("var: Array<Int>;")
            }
            exception.position shouldBe 4
            exception.unexpectedToken shouldBe Token.Colon
        }

        it("no colon token") {
            val exception = shouldThrow<ParsingException> {
                parseD("var x Array<Int>;")
            }
            exception.position shouldBe 11
            exception.unexpectedToken shouldBe Token.Array
        }

        it("no array token") {
            val exception = shouldThrow<ParsingException> {
                parseD("var x: <Int>;")
            }
            exception.position shouldBe 8
            exception.unexpectedToken shouldBe Token.Langle
        }

        it("no langle token") {
            val exception = shouldThrow<ParsingException> {
                parseD("var x: Array Int>;")
            }
            exception.position shouldBe 16
            exception.unexpectedToken shouldBe Token.Name("Int")
        }

        it("no T inside angled brackets") {
            val exception = shouldThrow<ParsingException> {
                parseD("var x: Array<>;")
            }
            exception.position shouldBe 14
            exception.unexpectedToken shouldBe Token.Rangle
        }

        it("no rangle token") {
            val exception = shouldThrow<ParsingException> {
                parseD("var x: Array<Int;")
            }
            exception.position shouldBe 17
            exception.unexpectedToken shouldBe Token.Semicolon
        }

        it("no semicolon token") {
            val exception = shouldThrow<ParsingException> {
                parseD("var x: Array<Int>")
            }
            exception.position shouldBe 18
            exception.unexpectedToken shouldBe Token.End
        }
    }

    it("eof expected after semicolon") {
        val exception = shouldThrow<ParsingException> {
            parseD("var x: Array<Int>; var y: Array<Long>;")
        }
        exception.position shouldBe 22
        exception.unexpectedToken shouldBe Token.Var
    }
})

private fun parseD(input: String): Tree {
    val parser = Parser(StringReader(input))
    return parser.parseD()
}

private fun parseT(input: String): Tree {
    val parser = Parser(StringReader(input))
    return parser.parseT()
}
