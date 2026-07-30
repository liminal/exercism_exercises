class DiamondPrinter {

    fun printToList(char: Char) : List<String> {
        if (char == 'A') return listOf(char.toString())
        val seq = 'A'..char
        val fullSeq = seq + seq.reversed().drop(1)
        return fullSeq.map { generateRow(it, char - 'A')}
    }

    private fun generateRow(char: Char, cols : Int) : String {
        val arr = CharArray(cols*2 +1) { ' ' }
        val pos = cols - (char - 'A')
        arr[pos] = char
        arr[arr.lastIndex - pos] = char
        return String(arr)
    }

}
