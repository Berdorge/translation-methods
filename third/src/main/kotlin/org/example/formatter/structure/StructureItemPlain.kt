package org.example.formatter.structure

import org.example.formatter.StatefulOutput

class StructureItemPlain(private val text: String) : StructureItem() {
    override val length = text.length

    override fun toString() = text

    override fun appendContentTo(output: StatefulOutput) {
        output.append(toString())
    }
}
