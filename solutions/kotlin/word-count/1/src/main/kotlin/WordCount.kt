object WordCount {

    val punctuation = "[,:!?.\t\n &@$%^]".toRegex()

    fun phrase(phrase: String): Map<String, Int> {
        return phrase.split(punctuation)
            .map { word -> word.trim('\'') }
            .filter(String::isNotEmpty)
            .groupingBy { it.lowercase() }
            .eachCount()
    }
}
