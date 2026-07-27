object Bob {
    fun isQuestion(input: String) = input.lastOrNull() == '?'

    fun isYelling(input: String) = input.any { it.isLetter() } && input == input.uppercase()
    
    fun hey(input: String): String {
        val text = input.trimEnd()
        return when {
            isYelling(text) && isQuestion(text) -> "Calm down, I know what I'm doing!"
            isYelling(text) -> "Whoa, chill out!"
            isQuestion(text) -> "Sure."
            text.isBlank() -> "Fine. Be that way!"
            else -> "Whatever."
        }
    }
}
