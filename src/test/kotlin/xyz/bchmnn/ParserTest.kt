package xyz.bchmnn

import org.junit.Test
import xyz.bchmnn.chsvparser.ChSVParser
import kotlin.test.assertEquals

class ParserTest {

    @Test
    fun test() {

        val text = "Foo,Bar|Baz,Boz"

        val parser = ChSVParser(term = "|")
        val content = parser.parse(text)
        assertEquals(2, content.rows.size)
        content.rows.forEach { row -> assertEquals(2, row.elems.size) }
        assertEquals("Foo", content.rows[0].elems[0])
        assertEquals("Bar", content.rows[0].elems[1])
        assertEquals("Baz", content.rows[1].elems[0])
        assertEquals("Boz", content.rows[1].elems[1])

    }

}
