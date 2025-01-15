package org.example.formatter.structure

import org.example.formatter.StatefulOutput

class NonWrappedList(
    private val children: List<StructureItem>,
    private val separator: String = ""
) : StructureItem() {
    override val length = children.sumOf { child ->
        child.length
    }

    override fun toString(): String {
        return children.joinToString(separator = "") { child ->
            child.toString()
        }
    }

    override fun appendContentTo(output: StatefulOutput) {
        val firstChild = children.firstOrNull() ?: return
        firstChild.appendContentTo(output)
        for (child in children.subList(1, children.size)) {
            output.append(separator)
            child.appendContentTo(output)
        }
    }
}
