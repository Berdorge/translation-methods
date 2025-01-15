package org.example.formatter.structure

import org.example.formatter.LineType
import org.example.formatter.StatefulOutput

class LineTypeMarker(
    private val lineType: LineType
) : StructureItem() {
    override val length: Int = 0

    override fun toString(): String = ""

    override fun appendContentTo(output: StatefulOutput) {
        val previousUnit = output.popLineType()
        val newlines = newlinesBetween(previousUnit, lineType)
        repeat(newlines) {
            output.appendLine()
        }
        output.pushLineType(lineType)
    }

    private fun newlinesBetween(previousType: LineType?, currentType: LineType): Int {
        return when {
            previousType == null -> 0
            previousType == LineType.TYPE_DEFINITION && currentType == LineType.TYPE_DEFINITION -> 2
            previousType == LineType.METHOD && currentType == LineType.METHOD -> 1
            previousType == LineType.BLOCK && currentType == LineType.BLOCK -> 1
            previousType == LineType.STATEMENT && currentType == LineType.STATEMENT -> 0
            previousType != currentType -> 1
            else -> 0
        }
    }
}
