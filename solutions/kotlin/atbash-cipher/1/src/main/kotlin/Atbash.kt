object Atbash {

    private val invalid = "[^a-z0-9]".toRegex()

    fun encode(s: String): String{
        return decode(s)
            .chunked(5)
            .joinToString(" ")
    }

    fun decode(s: String): String{
        return s.lowercase()
            .replace(invalid, "")
            .map { encodeChar(it) }
            .joinToString("")
    }

    private fun encodeChar(char: Char): Char {
        if (!char.isLetter()) return char
        return 'z' - (char - 'a')
    }
}
