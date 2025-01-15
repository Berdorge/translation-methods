package org.example.parser

data class LexingException(
    val unexpectedCharacter: Char,
    val position: Int
) : RuntimeException("Unexpected character $unexpectedCharacter at position $position")
