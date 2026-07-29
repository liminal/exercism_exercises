object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        if (int < 2) return emptyList()
        val factors = mutableListOf<Int>()
        var factor = 2
        var n = int
        while (factor < n) {
            if (n % factor == 0) {
                factors += factor
                n /= factor
            } else {
                factor += 1
            }
        }
        factors += n
        return factors

    }

    fun primeFactors(long: Long): List<Long> {
        if (long < 2) return emptyList()
        val factors = mutableListOf<Long>()
        var factor = 2L
        var n = long
        while (factor < n) {
            if (n % factor == 0L) {
                factors += factor
                n /= factor
            } else {
                factor += 1
            }
        }
        factors += n
        return factors
    }
}
