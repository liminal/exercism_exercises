class IsbnVerifier {

    private val dashed = "\\d-\\d{3}-\\d{5}-[\\dX]".toRegex()
    private val undashed = "\\d{9}[\\dX]".toRegex()


    fun isValid(number: String): Boolean {
        return isWellFormed(number) && checkDigits(number)
    }

    private fun isWellFormed(number: String): Boolean {
        return dashed.matches(number) ||
                undashed.matches(number)
    }

    private fun checkDigits(number: String): Boolean {
        val digits = number.replace("-", "")
            .map { if (it == 'X') 10 else it - '0' }

        return (
                digits[0] * 10 +
                        digits[1] * 9 +
                        digits[2] * 8 +
                        digits[3] * 7 +
                        digits[4] * 6 +
                        digits[5] * 5 +
                        digits[6] * 4 +
                        digits[7] * 3 +
                        digits[8] * 2 +
                        digits[9] * 1) % 11 == 0


    }
}
