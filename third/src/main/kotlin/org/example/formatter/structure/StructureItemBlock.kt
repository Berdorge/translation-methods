package org.example.formatter.structure

import org.example.formatter.StatefulOutput

class StructureItemBlock(
    private val child: StructureItem,
    private val addLastNewline: Boolean
) : StructureItem() {
    override val length: Int = child.length + 2

    override fun toString(): String {
        return "{$child}"
    }

    override fun appendContentTo(output: StatefulOutput) {
        output.appendLine("{")
        output.addIndentationLevel()
        output.pushLineType(null)
        child.appendContentTo(output)
        output.removeIndentationLevel()
        output.popLineType()
        output.appendIndented("}")
        if (addLastNewline) {
            output.appendLine()
        }
    }
}
