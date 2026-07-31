data class FlowerFieldBoard(val inputBoard: List<String>) {

    val board : List<CharArray> = inputBoard.map { it.toCharArray() }

    val xRange by lazy { board[0].indices }
    val yRange by lazy { board.indices }

    fun withNumbers(): List<String> {
        if (inputBoard.isEmpty()) return inputBoard
        if (inputBoard == listOf("")) return inputBoard
        for (y in yRange) {
            for (x in xRange) {
                if (board[y][x] == '*') {
                    increaseCount(x,y)
                }
            }
        }
        return board.map { it.joinToString("") }
    }

    private fun increaseCount(flowerX: Int, flowerY: Int) {
        for (x in flowerX -1 .. flowerX+1) {
            for (y in flowerY-1 .. flowerY+1) {
                if (x in xRange && y in yRange) {
                    when (val char = board[y][x]) {
                        ' ' -> board[y][x] = '1'
                        in '1'..'9' -> board[y][x] = '0' + (char - '0')+1
                    }
                }
            }
        }
    }
}
