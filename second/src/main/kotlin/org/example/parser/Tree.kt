package org.example.parser

data class Tree(
    val node: String,
    val children: List<Tree>
) {
    companion object {
        fun leaf(node: String) = Tree(node = node, children = emptyList())
    }
}
