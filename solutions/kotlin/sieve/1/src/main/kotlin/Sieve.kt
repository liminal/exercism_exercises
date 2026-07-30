import kotlin.math.sqrt

object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> {
        val numbers = (2..upperBound).toMutableList()
        val limit = sqrt(upperBound.toDouble()).toInt()
        for (n in 2..limit) numbers -= n * n..upperBound step n
        return numbers
    }
}
