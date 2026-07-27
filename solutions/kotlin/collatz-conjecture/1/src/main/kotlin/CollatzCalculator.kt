object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start < 1) throw IllegalArgumentException()
        var steps = 0
        var number = start
        while (number > 1) {
            steps++
            if (number % 2 == 0) {
                number /= 2
            } else {
                number = number * 3 + 1
            }
        }
        return steps
    }
}
