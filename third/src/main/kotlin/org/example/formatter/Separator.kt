package org.example.formatter

data class Separator(
    val content: String,
    val shouldPrependWhitespace: Boolean,
    val shouldAppendWhitespace: Boolean,
    val splitLineMode: SplitLineMode
) {
    val length = content.length + if (shouldPrependWhitespace) {
        1
    } else {
        0
    } + if (shouldAppendWhitespace) {
        1
    } else {
        0
    }

    override fun toString(): String = buildString {
        if (shouldPrependWhitespace) {
            append(' ')
        }
        append(content)
        if (shouldAppendWhitespace) {
            append(' ')
        }
    }

    companion object {
        val SPACE = Separator(
            content = "",
            shouldPrependWhitespace = false,
            shouldAppendWhitespace = true,
            splitLineMode = SplitLineMode.ON_PREVIOUS_LINE
        )
        val ASSIGNMENT = Separator(
            content = "=",
            shouldPrependWhitespace = true,
            shouldAppendWhitespace = true,
            splitLineMode = SplitLineMode.ON_PREVIOUS_LINE
        )
        val MEMBER_ACCESS = Separator(
            content = ".",
            shouldPrependWhitespace = false,
            shouldAppendWhitespace = false,
            splitLineMode = SplitLineMode.ON_NEXT_LINE
        )

        fun comma(content: String = ",") = Separator(
            content = content,
            shouldPrependWhitespace = false,
            shouldAppendWhitespace = true,
            splitLineMode = SplitLineMode.ON_PREVIOUS_LINE
        )

        fun binaryOperator(operator: String) = Separator(
            content = operator,
            shouldPrependWhitespace = true,
            shouldAppendWhitespace = true,
            splitLineMode = SplitLineMode.ON_NEXT_LINE
        )
    }

    enum class SplitLineMode {
        ON_PREVIOUS_LINE,
        ON_NEXT_LINE
    }
}
