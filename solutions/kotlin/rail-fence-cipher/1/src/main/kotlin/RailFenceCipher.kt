class RailFenceCipher(val rails : Int) {


    fun getEncryptedData(input: String): String {
        val code: List<MutableList<Char>> = (0 until rails).map { mutableListOf() }
        val railsIdx= generateRails(rails, input.length)
        input.forEachIndexed { index, ch -> code[railsIdx[index]].add(  ch) }
        return code.flatten().joinToString("")
    }

    fun getDecryptedData(input: String): String {
        val code: List<MutableList<Int>> = (0 until rails).map { mutableListOf() }
        val railsIdx= generateRails(rails, input.length)
        railsIdx.forEachIndexed { index, ch -> code[railsIdx[index]].add(index) }
        val indexes = code.flatten()
        val outCharArray = CharArray(input.length)
        input.forEachIndexed { index, ch ->
            val idx = indexes[index]
            outCharArray[idx] = ch }

        return String(outCharArray)
    }

    private fun generateRails(nrOfRails : Int, nrOfLetters: Int): List<Int> {
        val result = mutableListOf<Int>()
        var rail = 0
        var dir = 1
        (1..nrOfLetters).forEach { _ ->
            result.add(rail)
            when {
                (rail + dir) >= nrOfRails -> dir = -1
                (rail + dir) < 0 -> dir = 1
            }
            rail += dir
        }
        return result
    }
}
