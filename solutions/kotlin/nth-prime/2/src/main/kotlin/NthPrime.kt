object Prime {

    fun isPrime(n: Int) : Boolean {
        when {
            n < 2 -> return false
            n % 2 == 0 -> return n == 2
            n % 3 == 0 -> return n == 3
            else -> {
                var d: Int = 5
                while (d * d <= n) {
                    if (n % d == 0) return false
                    d += 2
                    if (n % d == 0) return false
                    d += 4
                }
                return true
            }
        }
    }

    fun generatePrimes() = sequence {
        yield(2)
        var p = 3
        while (true) {
            if (isPrime(p)) yield(p)
            p += 2
        }
    }

    fun nth(n: Int): Int {
        require(n > 0) { "n must be positive" }
        return generatePrimes().take(n).last()
    }
}
