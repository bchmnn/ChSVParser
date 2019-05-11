package xyz.bchmnn.chsvparser

class Content {

    var rows:List<Row> = emptyList()

    fun addRow(row:Row) {
        rows = rows + row
    }

    class Row {

        var elems:List<String> = emptyList()

        fun add(elem:String) {
            elems = elems + elem
        }


    }

}