object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        val numrange = 1 until limit
        return  factors.filter { it != 0 }
            .flatMap { f -> numrange.filter { n -> n % f == 0} }
            .toSet()
            .sum()
    }
}
