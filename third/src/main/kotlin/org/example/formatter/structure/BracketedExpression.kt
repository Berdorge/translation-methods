package org.example.formatter.structure

import org.example.formatter.StatefulOutput

class BracketedExpression(
    private val startBracket: String,
    private val endBracket: String,
    private val middle: StructureItem
) : StructureItem() {
    override val length: Int = middle.length + startBracket.length + endBracket.length

    override fun toString() = "$startBracket$middle$endBracket"

    override fun appendContentTo(output: StatefulOutput) {
        val previousIndentation = output.indentation

        output.append(startBracket)

        val indentationIncrease = output.column - previousIndentation -
            StatefulOutput.INDENTATION_LEVEL
        output.indentation += if (indentationIncrease > 0) {
            indentationIncrease
        } else {
            StatefulOutput.INDENTATION_LEVEL
        }

        middle.appendContentTo(output)
        output.append(endBracket)

        output.indentation = previousIndentation
    }
}
