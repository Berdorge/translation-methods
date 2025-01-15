package org.example.formatter.structure

import org.example.formatter.Separator
import org.example.formatter.StatefulOutput
import kotlin.math.max

class WrappableList(
    val children: List<StructureItem>,
    val separator: Separator
) : StructureItem() {
    override val length: Int = children.sumOf { child ->
        child.length
    } + separator.length * max(children.size - 1, 0)

    override fun toString(): String {
        return children.joinToString(separator = separator.toString())
    }

    override fun appendContentTo(output: StatefulOutput) {
        var isFirstLineBroken = false
        val firstChild = children.firstOrNull() ?: return
        firstChild.appendContentTo(output)
        for (child in children.subList(1, children.size)) {
            isFirstLineBroken = isFirstLineBroken or appendSeparatorAndItem(
                output = output,
                separator = separator,
                item = child,
                shouldAddIndentOnWrap = !isFirstLineBroken
            )
        }
        if (isFirstLineBroken) {
            output.removeIndentationLevel()
        }
    }

    companion object {
        fun appendSeparatorAndItem(
            output: StatefulOutput,
            separator: Separator,
            item: StructureItem,
            shouldAddIndentOnWrap: Boolean
        ): Boolean {
            val isNextChildTooBig = output.lineSpaceLeft() < separator.length + item.length
            val nextIndentation = if (shouldAddIndentOnWrap) {
                output.indentation + StatefulOutput.INDENTATION_LEVEL
            } else {
                output.indentation
            }
            val isLineBroken = isNextChildTooBig && output.column > nextIndentation
            if (separator.splitLineMode == Separator.SplitLineMode.ON_PREVIOUS_LINE) {
                if (separator.shouldPrependWhitespace) {
                    output.append(" ")
                }
                output.append(separator.content)
                if (separator.shouldAppendWhitespace && !isLineBroken) {
                    output.append(" ")
                }
            }
            if (isLineBroken) {
                output.appendLine()
                if (shouldAddIndentOnWrap) {
                    output.addIndentationLevel()
                }
                output.appendIndent()
            }
            if (separator.splitLineMode == Separator.SplitLineMode.ON_NEXT_LINE) {
                if (separator.shouldPrependWhitespace && !isLineBroken) {
                    output.append(" ")
                }
                output.append(separator.content)
                if (separator.shouldAppendWhitespace) {
                    output.append(" ")
                }
            }
            item.appendContentTo(output)
            return isLineBroken
        }
    }
}
