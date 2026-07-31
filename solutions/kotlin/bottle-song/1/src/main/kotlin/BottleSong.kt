import java.util.Locale.getDefault

object BottleSong {
    fun recite(startBottles : Int, takeDown : Int) : String {
        return (startBottles downTo  startBottles - takeDown +1)
            .joinToString("\n\n") { bottles -> verse(bottles , bottles -1) }

    }

    private fun verse(
        startCount: Int,
        endCount: Int,
    ): String {
        val startCountStr = numberString(startCount)
        val endCountStr = numberString(endCount)

        val startBottle = pluralize(startCount, "bottle")
        val endBottle = pluralize(endCount, "bottle")

        val startCapitalized =
            startCountStr.replaceFirstChar { if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString() }
        return """
                $startCapitalized green $startBottle hanging on the wall,
                $startCapitalized green $startBottle hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be $endCountStr green $endBottle hanging on the wall.
        """.trimIndent()
    }

    private fun pluralize(count: Int, str: String): String {
        return if (count == 1) return str else str+"s"
    }

    private fun numberString(number: Int): String {
        return when (number) {
            10 -> "ten"
            9 -> "nine"
            8 -> "eight"
            7 -> "seven"
            6 -> "six"
            5 -> "five"
            4 -> "four"
            3 -> "three"
            2 -> "two"
            1 -> "one"
            0 -> "no"
            else -> error("invalid number of bottles: $number")
        }
    }

}
