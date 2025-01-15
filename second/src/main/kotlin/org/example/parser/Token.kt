package org.example.parser

sealed class Token {
    data object Var : Token()
    data object Colon : Token()
    data object Array : Token()
    data object Langle : Token()
    data object Rangle : Token()
    data object Semicolon : Token()
    data object End : Token()

    data class Name(val name: String) : Token()
}
