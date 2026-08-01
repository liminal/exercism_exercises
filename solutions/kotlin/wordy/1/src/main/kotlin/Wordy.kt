import kotlin.math.pow

object Wordy {

    fun answer(input: String): Int {
        if (!input.startsWith("What is ")) throw Exception()
        val line = input.removePrefix("What is ").removeSuffix("?").split(" ")

        return evalMath(ArrayDeque(line))
    }

    private fun evalMath(input: ArrayDeque<String>) : Int {
        val result = input.removeFirst().toIntOrNull() ?: throw Exception()
        if (input.isEmpty()) return result
        return operate(result, input)
    }

    private fun operate(acc: Int, input: ArrayDeque<String>): Int {
        val operation = input.removeFirst()
        val result = when (operation) {
            "plus" -> acc + input.removeFirst().toInt()
            "minus" -> acc - input.removeFirst().toInt()
            "multiplied" -> {
                input.popRequiredWord("by")
                acc * input.removeFirst().toInt()
            }
            "divided" -> {
                input.popRequiredWord("by")
                acc / input.removeFirst().toInt()
            }
            "raised" -> handlePower(acc, input)
            else -> throw Exception()
        }
        return if (input.isEmpty()) {
            result
        } else {
            operate(result, input)
        }
    }

    private fun handlePower(acc: Int, input: ArrayDeque<String>) : Int {
        input.popRequiredWord("to")
        input.popRequiredWord("the")
        val exp = input.removeFirst().parseOrdinal() ?: throw Exception()
        input.popRequiredWord("power")
        return acc.toDouble().pow(exp.toDouble()).toInt()
    }

    private fun ArrayDeque<String>.popRequiredWord(word: String) {
        val firstWord = this.removeFirst()
        if (firstWord != word) throw Exception("Expected $word, was $firstWord")
    }

    private val ORDINALS = "(\\d+)(st|nd|rd|th)".toRegex()

    private fun String.parseOrdinal(): Int? {
        return ORDINALS.matchEntire(this)?.destructured?.let { (number) -> number.toInt() }
    }
}
