object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        if (rows <= 0) return emptyList()
        val triangle = mutableListOf(listOf(1))
        var nextRow = listOf(1, 1)
        (1 until rows).forEach { _ ->
            triangle.add(nextRow)
            nextRow = listOf(1) + nextRow.zipWithNext { a, b -> a + b } + 1
        }
        return triangle
    }

}
