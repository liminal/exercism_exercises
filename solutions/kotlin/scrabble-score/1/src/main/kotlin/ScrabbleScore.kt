object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        return when (c) {
            in "aeioulnrst" -> 1
            'd', 'g' -> 2
            in "bcmp" -> 3
            in "fhvwy" -> 4
            'k' -> 5
            'j','x' -> 8
            'q','z' -> 10
            else -> 0
        }
    }

    fun scoreWord(word: String): Int {
        return word.lowercase().sumOf { c -> scoreLetter(c) }
    }
}
