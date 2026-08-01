class NumberSpeller {

    companion object {
        const val THOUSAND = 1000
        const val MILLION = 1000 * THOUSAND
        const val BILLION = 1000 * MILLION
    }

    val digits = mapOf<Int, String>(
        0 to "zero",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",

        )

    fun say(input: Long): String {
        require(input in 0..999999999999)
        return when {
            input < BILLION -> sayInt(input.toInt())
            else -> sayInt((input / BILLION).toInt()) + " billion " + sayInt((input % BILLION).toInt())
        }.trimEnd().removeSuffix("-zero").removeSuffix(" zero")
    }

    private fun sayInt(input: Int): String {
        require(input in 0..< BILLION)
        return when {
            input <= 10 -> sayDigits(input)
            input < 100 -> sayDecades(input)
            input < THOUSAND -> sayDigits(input / 100) + " hundred " + sayDecades(input % 100)
            input < MILLION -> sayInt(input / THOUSAND) + " thousand " + sayInt(input % THOUSAND)
            else -> sayInt(input / MILLION) + " million " + sayInt(input % MILLION)
        }
    }

    private fun sayDigits(input: Int): String = digits[input]!!

    private fun sayTeens(input: Int): String {
        return when (input) {
            10 -> "ten"
            11 -> "eleven"
            12 -> "twelve"
            13 -> "thirteen"
            14 -> "fourteen"
            15 -> "fifteen"
            16 -> "sixteen"
            17 -> "seventeen"
            18 -> "eighteen"
            19 -> "nineteen"
            else -> ""
        }
    }

    private fun sayDecades(input: Int): String {
        return when (input) {
            in 10..19 -> sayTeens(input)
            in 20..29 -> "twenty-" + sayDigits(input % 10)
            in 30..39 -> "thirty-" + sayDigits(input % 10)
            in 40..49 -> "forty-" + sayDigits(input % 10)
            in 50..59 -> "fifty-" + sayDigits(input % 10)
            in 60..69 -> "sixty-" + sayDigits(input % 10)
            in 70..79 -> "seventy-" + sayDigits(input % 10)
            in 80..89 -> "eighty-" + sayDigits(input % 10)
            in 90..99 -> "ninety-" + sayDigits(input % 10)
            else -> ""
        }
    }

}

