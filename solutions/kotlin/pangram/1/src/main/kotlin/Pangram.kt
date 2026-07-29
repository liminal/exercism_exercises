object Pangram {

    fun isPangram(input: String): Boolean {
        // Let's go with the least efficient implementation :D
        val lower = input.lowercase()

        return ('a'..'z').all { c -> c in lower }
    }
}
