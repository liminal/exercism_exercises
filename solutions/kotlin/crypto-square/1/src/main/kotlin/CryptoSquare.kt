object CryptoSquare {

    val stripChars = "[^a-z0-9]".toRegex()

    fun ciphertext(plaintext: String): String {
        val normalized = plaintext.lowercase().replace(stripChars, "")
        if (normalized.isEmpty()) return ""
        val (c, r) = findCandR(normalized)
        val padded = normalized.padEnd(c*r )
        val chunks = padded.chunked(c)
        val sb = StringBuilder()
        for (i in 0 until c) {
            for (j in 0 until r) {
                sb.append(chunks[j][i])
            }
            sb.append(' ')
        }
        return sb.toString().dropLast(1)
    }

    private fun findCandR(text: String): Pair<Int, Int> {
        val lom = text.length
        for (c in 1 .. lom) {
            val r = if (lom % c == 0) lom / c else (lom / c + 1)
            if (c >= r && (c - r <= 1)) return c to r
        }
        error("can't find c and r for lom $lom")
    }

}
