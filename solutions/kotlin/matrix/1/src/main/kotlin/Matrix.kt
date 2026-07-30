class Matrix(private val matrixAsString: String) {

    val matrix = matrixAsString.split('\n').map { row -> row.split(' ').map { column -> column.toInt() } }

    fun column(colNr: Int): List<Int> {
        return matrix.map { row -> row[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return matrix[rowNr-1]
    }
}
