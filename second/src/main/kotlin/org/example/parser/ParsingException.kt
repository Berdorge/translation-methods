package org.example.parser

data class ParsingException(
    val unexpectedToken: Token,
    val position: Int
) : RuntimeException("Unexpected token $unexpectedToken at position $position")
