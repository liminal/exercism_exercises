object RomanNumerals {

    fun value(n: Int): String {
        return romanizeImpl(n, "")
    }

    private fun romanizeImpl(number: Int, str: String): String {
        return when  {
            number >= 1000 -> romanizeImpl(number - 1000, str + "M")
            number >= 900 -> romanizeImpl(number - 900, str + "CM")
            number >= 500 -> romanizeImpl(number - 500, str + "D")
            number >= 400 -> romanizeImpl(number - 400, str + "CD")
            number >= 100 -> romanizeImpl(number - 100, str + "C")

            number >= 90 -> romanizeImpl(number - 90, str + "XC")
            number >= 50 -> romanizeImpl(number - 50, str + "L")
            number >= 40 -> romanizeImpl(number - 40, str + "XL")
            number >= 10 -> romanizeImpl(number - 10, str + "X")

            number >= 9 -> romanizeImpl(0, str + "IX")
            number >= 5 -> romanizeImpl(number - 5, str + "V")
            number >= 4 -> romanizeImpl(0, str + "IV")
            number >= 1 -> romanizeImpl(number - 1, str + "I")
            else -> str
        }
    }
}
