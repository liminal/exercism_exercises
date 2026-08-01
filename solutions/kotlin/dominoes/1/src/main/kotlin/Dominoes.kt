class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int) {
    override fun toString(): String = "[$left|$right]"

    fun flip() : Domino = Domino(right, left)
}

object Dominoes {

    fun formChain(vararg dominoes: Domino): List<Domino> {
        return formChain(dominoes.toList())
    }

    fun formChain(inputDominoes: List<Domino> = emptyList()): List<Domino> {
        if (inputDominoes.isEmpty()) return emptyList()
        if (inputDominoes.size == 1 ) {
            return if (inputDominoes[0].left == inputDominoes[0].right) inputDominoes else { throw ChainNotFoundException("Domino form chain not found") }
        }
        for (d in inputDominoes) {
            var ch =  validChain(listOf(d), inputDominoes - d)
            if (ch.isNotEmpty()) return ch
            ch =  validChain(listOf(d.flip()), inputDominoes - d)
            if (ch.isNotEmpty()) return ch
        }
        throw ChainNotFoundException("Domino form chain not found")
    }

    private fun validChain(startDominoes: List<Domino>, dominoes: List<Domino>): List<Domino> {
        for (nextDomino in dominoes) {
            if (nextDomino.left == startDominoes.last().right) {
                val restDominoes = dominoes - nextDomino
                if (restDominoes.isEmpty()) {
                    if (nextDomino.right == startDominoes.first().left) {
                        return startDominoes + nextDomino
                    }
                } else {
                    val ch = validChain(startDominoes+nextDomino, restDominoes)
                    if (ch.isNotEmpty()) return ch
                }

            }
            if (nextDomino.right == startDominoes.last().right) {
                val flipmino = nextDomino.flip()
                val restDominoes = dominoes - nextDomino
                if (restDominoes.isEmpty()) {

                    if (flipmino.right == startDominoes.first().left) {
                        return startDominoes + flipmino
                    }
                } else {
                    val ch = validChain(startDominoes+flipmino, restDominoes)
                    if (ch.isNotEmpty()) return ch
                }

            }
        }
        return emptyList()
    }
}
