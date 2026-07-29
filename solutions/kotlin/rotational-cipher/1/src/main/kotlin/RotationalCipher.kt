class RotationalCipher(val key: Int) {

    fun encode(text: String): String {
        return text.map { c -> rotChar(c) }
            .joinToString("")
    }

    private fun rotChar(ch: Char): Char {
        return when (ch) {
            in 'a'..'z' -> ('a' + (((ch - 'a') + key) % 26))
            in 'A'..'Z' -> ('A' +(((ch - 'A') + key) % 26))

            else -> ch
        }
    }
}
