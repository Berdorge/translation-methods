package org.example.formatter.structure

import org.example.formatter.Separator
import org.example.formatter.StatefulOutput

class TernaryOperator(
    private val left: StructureItem,
    private val middle: StructureItem,
    private val right: StructureItem,
    private val leftMiddleSeparator: Separator,
    private val middleRightSeparator: Separator
) : StructureItem() {
    override val length: Int = left.length + middle.length + right.length +
        leftMiddleSeparator.length + middleRightSeparator.length

    override fun toString(): String {
        return "$left$leftMiddleSeparator$middle$middleRightSeparator$right"
    }

    override fun appendContentTo(output: StatefulOutput) {
        left.appendContentTo(output)
        var isFirstLineBroken = WrappableList.appendSeparatorAndItem(
            output = output,
            separator = leftMiddleSeparator,
            item = middle,
            shouldAddIndentOnWrap = true
        )
        isFirstLineBroken = isFirstLineBroken or WrappableList.appendSeparatorAndItem(
            output = output,
            separator = middleRightSeparator,
            item = right,
            shouldAddIndentOnWrap = !isFirstLineBroken
        )
        if (isFirstLineBroken) {
            output.removeIndentationLevel()
        }
    }
}
