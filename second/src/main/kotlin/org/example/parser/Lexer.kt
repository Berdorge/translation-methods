package org.example.parser

import java.io.IOException
import java.io.PushbackReader
import java.io.Reader

class Lexer(input: Reader) {
    private val input = PushbackReader(input, PUSHBACK_BUFFER_SIZE)
    private var position = 0

    fun position() = position

    @Throws(IOException::class)
    fun nextToken(): Token {
        skipWhitespace()

        if (tryReadingWord("var")) {
            return Token.Var
        }

        if (tryReadingWord("Array")) {
            return Token.Array
        }

        tryReadingName()?.let { return it }

        return when (val code = read()) {
            ':'.code -> Token.Colon
            '<'.code -> Token.Langle
            '>'.code -> Token.Rangle
            ';'.code -> Token.Semicolon
            -1 -> Token.End
            else -> {
                unread(code)
                throw LexingException(code.toChar(), position)
            }
        }
    }

    @Throws(IOException::class)
    private fun skipWhitespace() {
        while (isSpace(peek())) {
            read()
        }
    }

    private fun isSpace(code: Int): Boolean {
        return Character.isWhitespace(code)
    }

    @Throws(IOException::class)
    private fun tryReadingWord(word: String): Boolean {
        if (!tryReadingString(word)) {
            return false
        }
        val code = peek()
        if (Character.isLetter(code)) {
            unread(word)
            return false
        }
        return true
    }

    @Throws(IOException::class)
    private fun tryReadingName(): Token? {
        var code = read()
        if (!Character.isLetter(code)) {
            unread(code)
            return null
        }
        val name = StringBuilder()
        while (Character.isLetter(code) || Character.isDigit(code)) {
            name.append(code.toChar())
            code = read()
        }
        unread(code)
        return Token.Name(name.toString())
    }

    @Throws(IOException::class)
    private fun tryReadingString(str: String): Boolean {
        for (i in str.indices) {
            val code = read()
            if (code != str.codePointAt(i)) {
                unread(code)
                unread(str.subSequence(0 until i))
                return false
            }
        }
        return true
    }

    @Throws(IOException::class)
    private fun peek(): Int {
        val code = read()
        unread(code)
        return code
    }

    @Throws(IOException::class)
    private fun read(): Int {
        val code = input.read()
        position += 1
        return code
    }

    @Throws(IOException::class)
    private fun unread(sequence: CharSequence) {
        for (i in sequence.indices.reversed()) {
            unread(sequence[i].code)
        }
    }

    @Throws(IOException::class)
    private fun unread(code: Int) {
        position -= 1
        if (code != -1) {
            input.unread(code)
        }
    }

    companion object {
        private const val PUSHBACK_BUFFER_SIZE = 1024
    }
}
