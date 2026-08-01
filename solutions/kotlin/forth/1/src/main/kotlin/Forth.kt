import kotlin.collections.isNotEmpty
import kotlin.text.split

class Forth {

    fun evaluate(vararg line: String): List<Int> {
        val evaluator = Evaluator()
        for (l in line) {
            evaluator.handleLine(l)
        }
        return evaluator.stack
    }

    class Evaluator {
        companion object {
            val NUMBER = "[0-9]+".toRegex()
            val CUSTOM_DEFINITION = ": (\\S+) (.+) ;".toRegex()
        }

        val stack: ArrayDeque<Int> = ArrayDeque()
        val customWords = mutableMapOf<String, String>()

        fun handleLine(line: String) {
            val line = line.lowercase()
            CUSTOM_DEFINITION.matchEntire(line.lowercase())
                ?.destructured
                ?.let { (wordName, definition) ->
                    if (NUMBER.matches(wordName)) { error("illegal operation") }
                    customWords[wordName.lowercase()] = replaceCustomWords(definition.lowercase())
                    return
            }
            val tokenList = replaceCustomWords(line).split(" ")

            handleTokenList(tokenList)
        }

        private fun replaceCustomWords(line: String) : String {
            var line = line
            for ((word, def) in customWords.entries) {
                line = line.replace(word, def)
            }
            return line
        }

        fun handleTokenList(tokenList: List<String>) {
            for (token in tokenList) {
                NUMBER.matchEntire(token)?.apply {
                    stack.addLast(token.toInt())
                    continue
                }
                when (token.lowercase()) {
                    "+" -> handlePlus()
                    "-" -> handleMinus()
                    "*" -> handleTimes()
                    "/" -> handleDivision()
                    "dup" -> handleDup()
                    "drop" -> handleDrop()
                    "swap" -> handleSwap()
                    "over" -> handleOver()
                    else -> error("undefined operation")
                }
            }

        }

        private fun ArrayDeque<Int>.requireAtLeast2ElementsOnStack() {
            require(isNotEmpty()) { "empty stack" }
            require(this.size != 1) { "only one value on the stack" }
        }

        fun handlePlus() {
            stack.requireAtLeast2ElementsOnStack()
            stack.addLast(stack.removeLast() + stack.removeLast())
        }

        fun handleMinus() {
            stack.requireAtLeast2ElementsOnStack()
            stack.addLast(-stack.removeLast() + stack.removeLast())
        }

        fun handleTimes() {
            stack.requireAtLeast2ElementsOnStack()
            stack.addLast(stack.removeLast() * stack.removeLast())
        }

        fun handleDivision() {
            stack.requireAtLeast2ElementsOnStack()
            val divisor = stack.removeLast()
            require(divisor != 0) { "divide by zero" }
            val denominator = stack.removeLast()
            stack.addLast(denominator / divisor)
        }
        fun handleDup() {
            require(stack.isNotEmpty()) { "empty stack" }
            stack.addLast(stack.last())
        }
        fun handleDrop() {
            require(stack.isNotEmpty()) { "empty stack" }
            stack.removeLast()
        }
        fun handleSwap() {
            stack.requireAtLeast2ElementsOnStack()
            val a = stack.removeLast()
            val b = stack.removeLast()
            stack.addLast(a)
            stack.addLast(b)
        }
        fun handleOver() {
            stack.requireAtLeast2ElementsOnStack()
            val a = stack.removeLast()
            val b = stack.removeLast()
            stack.addLast(b)
            stack.addLast(a)
            stack.addLast(b)
        }

    }

}
