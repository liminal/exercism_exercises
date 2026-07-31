object PigLatin {

    const val VOWELS = "aeiou"

    val RULE1 = "^([$VOWELS]|xr|yt).*".toRegex()

    val RULE2 = "^([^$VOWELS]+)(.*)".toRegex()

    val RULE3 = "^([^$VOWELS]*qu)(.*)".toRegex()

    val RULE4 = "^([^$VOWELS]+)(y.*)".toRegex()

    fun translate(phrase: String): String {
        require(phrase.isNotEmpty()) { "phrase must not be empty" }
        return phrase.split(' ').joinToString(" ") { translateWord(it) }
    }

    fun translateWord(word: String): String {
        require(word.isNotEmpty()) { "word must not be empty" }

        if (word.matches(RULE1)) {
            return word + "ay"
        }

        RULE3.matchEntire(word)?.destructured?.let { (start, end) ->
            return end + start + "ay"
        }
        RULE4.matchEntire(word)?.destructured?.let { (start, end) ->
            return end + start + "ay"
        }
        RULE2.matchEntire(word)?.destructured?.let { (start, end) ->
            return end + start + "ay"
        }

        return word
    }
}
