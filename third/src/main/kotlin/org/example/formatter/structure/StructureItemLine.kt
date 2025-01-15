package org.example.formatter.structure

import org.example.formatter.StatefulOutput

object StructureItemLine : StructureItem() {
    override val length: Int = 1

    override fun toString(): String = "\n"

    override fun appendContentTo(output: StatefulOutput) {
        output.appendLine()
    }
}
