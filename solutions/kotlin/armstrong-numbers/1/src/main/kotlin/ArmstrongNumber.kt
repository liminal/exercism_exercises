import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        var n = input
        val digits = mutableListOf<Int>()
        while (n > 0) {
            digits.add(n % 10)
            n /= 10
        }
        return digits.sumOf { it.toDouble().pow(digits.size.toDouble()).toInt() } == input
    }

}
