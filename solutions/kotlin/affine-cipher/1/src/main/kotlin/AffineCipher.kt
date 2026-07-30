import java.lang.Math.floorMod

object AffineCipher {
    val invalid = "[^a-z0-9]".toRegex()

    fun encode(input: String, a: Int, b: Int) : String {
        require(gcd(a, 26) == 1)
        return input.lowercase()
            .replace(invalid, "")
            .map { encodeChar(it, a,b) }
            .joinToString("")
            .chunked(5)
            .joinToString(" ")
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
    fun encodeChar(char: Char, a: Int, b: Int) : Char {
        if (!char.isLetter()) return char
        return 'a' + (a*(char-'a') +b) % 26
    }

    fun decode(input: String, a: Int, b: Int) : String {
        require(gcd(a, 26) == 1)
        return input.lowercase()
            .replace(" ", "")
            .map { decodeChar(it, a,b) }.joinToString("")

    }

    fun decodeChar(char: Char, a: Int, b: Int) : Char {
        if (!char.isLetter()) return char
        return 'a' + floorMod(modInverse(a) * (char -'a' - b),  26)
    }

    private fun modInverse(a: Int) : Int {
        var x = 2
        while (a*x % 26 != 1) { x += 1 }
        return x
    }

}
