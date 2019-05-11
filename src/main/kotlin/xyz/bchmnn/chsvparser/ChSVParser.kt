package xyz.bchmnn.chsvparser

import java.lang.IllegalArgumentException
import kotlin.math.max
import kotlin.text.StringBuilder

class ChSVParser constructor(
    var sep: String = ",",
    var term: String = "\n"
) {

    init {
        if (sep == term)
            throw IllegalArgumentException(
                "Separator and line terminator should not equal"
            )
    }

    fun parse(text:String):Content {

        val len = max(sep.length, term.length)

        val content = Content()
        var row = Content.Row()

        val builder = StringBuilder()

        var i = 0
        while (i < text.length) {
            var isSep = true
            var isTerm = true

            for (j in 0 .. len) {
                if (i + j == text.length) {
                    if (j < sep.length) isSep = false
                    if (j < term.length) isTerm = false
                    break
                }
                if (j < sep.length && text[i + j] != sep[j])
                    isSep = false
                if (j < term.length && text[i + j] != term[j])
                    isTerm = false
                if (!(isSep || isTerm))
                    break
            }

            if (!isSep && !isTerm) builder.append(text[i])

            if (isSep || isTerm) {
                row.add(builder.toString())
                builder.clear()
            }

            if ((isSep && isTerm && sep.length > term.length) || (isSep && !isTerm)) {
                i += sep.length
            } else if (isTerm) {
                content.addRow(row)
                row = Content.Row()
                i += term.length
            }
            i++
        }
        if (builder.isNotEmpty())
            row.add(builder.toString())
        if (row.elems.isNotEmpty())
            content.addRow(row)

        return content
    }

}