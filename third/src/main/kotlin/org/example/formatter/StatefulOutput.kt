package org.example.formatter

import kotlin.math.max

class StatefulOutput {
    var indentation: Int = 0
    var column: Int = 0
        private set

    private val output = StringBuilder()
    private val lineTypesStack = mutableListOf<LineType?>()

    override fun toString(): String {
        return output.toString()
    }

    fun appendIndent() {
        appendIndented("")
    }

    fun appendIndented(content: String) {
        append(" ".repeat(indentation))
        append(content)
    }

    fun appendIndentedLine(line: String) {
        append(" ".repeat(indentation))
        appendLine(line)
    }

    fun append(content: String) {
        output.append(content)
        column += content.length
    }

    fun appendLine(content: String = "") {
        output.appendLine(content)
        column = 0
    }

    fun addIndentationLevel() {
        indentation += INDENTATION_LEVEL
    }

    fun removeIndentationLevel() {
        indentation -= INDENTATION_LEVEL
    }

    fun lineSpaceLeft(): Int {
        return max(0, 80 - column)
    }

    fun pushLineType(lineType: LineType?) {
        lineTypesStack.add(lineType)
    }

    fun popLineType() = lineTypesStack.removeLastOrNull()

    companion object {
        const val INDENTATION_LEVEL = 4
    }
}
