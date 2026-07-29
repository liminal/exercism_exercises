class Anagram(val source: String) {

    val sorted = source.lowercase().sortedLetters()

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { isAnagram(it.lowercase()) }.toSet()
    }

    fun isAnagram(word: String): Boolean {
        if (word.equals(source, ignoreCase = true)) return false
        if (word.sortedLetters() == sorted) return true
        return false
    }

    fun String.sortedLetters() :String {
        return this.toList().sorted().joinToString("")
    }
}
