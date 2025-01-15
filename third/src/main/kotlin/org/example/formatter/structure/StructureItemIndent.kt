package org.example.formatter.structure

import org.example.formatter.StatefulOutput

object StructureItemIndent : StructureItem() {
    override val length: Int = 0

    override fun toString(): String = ""

    override fun appendContentTo(output: StatefulOutput) {
        output.appendIndent()
    }
}
