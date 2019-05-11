package xyz.bchmnn.chsvparser

class Content {

    var rows:List<Row> = emptyList()

    fun addRow(row:Row) {
        rows = rows + row
    }


    /**
     * @return          string of rows in csv format
     */
    fun toCsv(): String {
        // TODO
        return ""
    }

    /**
     * @return          string of rows in excel format
     */
    fun toExcel(): String {
        // TODO
        return ""
    }

    /**
     * @return          ascii table of content
     */
    override fun toString(): String {
        // TODO
        return ""
    }

    // inner public class of rows
    class Row {

        var elems:List<String> = emptyList()

        fun add(elem:String) {
            elems = elems + elem
        }


    }
}