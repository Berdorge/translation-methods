package org.example.formatter

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.nio.file.Files
import java.nio.file.Path
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        System.err.println("Usage: formatter <input file> <output file>")
        exitProcess(1)
    }

    val inputFile = Path.of(args[0])
    val outputFile = Path.of(args[1])
    val output = Files.newInputStream(inputFile).use { inputStream ->
        val visitor = JavaFormatterVisitor()
        val stream = CharStreams.fromStream(inputStream)
        val lexer = JavaLexer(stream)
        val tokens = CommonTokenStream(lexer)
        val parser = JavaParser(tokens)
        val result = StatefulOutput()
        visitor.visitCompilationUnit(parser.compilationUnit())
            .appendContentTo(result)
        result.toString()
    }

    Files.newOutputStream(outputFile)
        .bufferedWriter(Charsets.UTF_8)
        .use { writer ->
            writer.write(output)
        }
}
