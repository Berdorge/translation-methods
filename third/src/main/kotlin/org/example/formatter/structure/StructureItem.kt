package org.example.formatter.structure

import org.example.formatter.StatefulOutput

abstract class StructureItem {
    abstract val length: Int

    abstract override fun toString(): String

    abstract fun appendContentTo(output: StatefulOutput)

    companion object {
        val EMPTY = StructureItemPlain("")
    }
}
