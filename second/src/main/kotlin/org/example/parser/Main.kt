package org.example.parser

import java.io.IOException
import java.io.OutputStreamWriter
import java.io.StringReader
import java.io.Writer
import java.nio.file.Files
import java.nio.file.Path
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        System.err.println("Usage: parser <input>")
        exitProcess(1)
    }

    val parsedTree = try {
        Parser(StringReader(args.first())).parseD()
    } catch (e: LexingException) {
        System.err.println(e.message)
        exitProcess(1)
    } catch (e: ParsingException) {
        System.err.println(e.message)
        exitProcess(1)
    }

    try {
        writeTreeToDot(parsedTree)
    } catch (e: IOException) {
        System.err.println("I/O exception occurred when writing to the output file: ${e.message}")
        exitProcess(1)
    }
}

@Throws(IOException::class)
private fun writeTreeToDot(tree: Tree) {
    OutputStreamWriter(
        Files.newOutputStream(Path.of("parsed-tree.dot")),
        Charsets.UTF_8
    ).use { writer ->
        writer.writeLine("digraph {")
        visitSubtree(writer = writer, subtree = tree, parent = null, nextId = 0)
        writer.writeLine("}")
    }
}

@Throws(IOException::class)
private fun visitSubtree(
    writer: Writer,
    subtree: Tree,
    parent: Int?,
    nextId: Int
): Int {
    writer.writeLine("$nextId [label=\"${subtree.node}\"];")
    if (parent != null) {
        writer.writeLine("$parent -> $nextId;")
    }

    var currentId = nextId + 1
    for (child in subtree.children) {
        currentId = visitSubtree(
            writer = writer,
            subtree = child,
            parent = nextId,
            nextId = currentId
        )
    }

    return currentId
}

@Throws(IOException::class)
fun Writer.writeLine(line: String) {
    write(line)
    write(System.lineSeparator())
}
