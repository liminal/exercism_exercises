data class MatrixCoordinate(val row: Int, val col: Int)

data class Matrix(val elements: List<List<Int>>) {

    val saddlePoints get() : Set<MatrixCoordinate> {
        val out = mutableSetOf<MatrixCoordinate>()
        for (rowNr in elements.indices) {
            for (colNr in elements[0].indices) {
                if (elements[rowNr][colNr] == row(rowNr).max() &&
                    elements[rowNr][colNr] == column(colNr).min()) {
                    out.add(MatrixCoordinate(rowNr+1, colNr+1))
                }
            }
        }
        return out
    }

    fun row(rowNr: Int): List<Int> {
        return elements[rowNr]
    }

    fun column(colNr: Int): List<Int> {
        return elements.map { it[colNr] }
    }
}