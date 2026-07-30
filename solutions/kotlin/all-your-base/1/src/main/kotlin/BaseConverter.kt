class BaseConverter(base:Int, number: IntArray) {

    init {
        require(base >= 2) { "Bases must be at least 2." }
        require(number.isNotEmpty()) { "You must supply at least one digit."}
        require(number.size < 2 || number.first() != 0) { "Digits may not contain leading zeros" }
        require(number.all { it < base }) { "All digits must be strictly less than the base." }
        require(number.all { it >= 0 }) { "Digits may not be negative." }
    }
    val actual : Int = number.reversed().mapIndexed { index, i -> i * (base pow index) }.sum().also { println(it) }

    fun convertToBase(newBase: Int): IntArray {
        require(newBase >= 2)
        if (actual < newBase) { return intArrayOf(actual) }
        val output = mutableListOf<Int>()
        var num = actual
        val largestDigitPos = largestPowOf(num, newBase)
        for (n in largestDigitPos downTo 0) {
            val posVal = newBase pow n
            output.add(num / posVal)
            num = num % posVal
        }
        return output.toIntArray()
    }

    private fun largestPowOf(num:Int, base:Int):Int {
        var pos = 0
        while ((base pow pos)  < num) { pos++}
        return --pos
    }

    private infix fun Int.pow(exp: Int) : Int {
        require(exp >= 0) { "Exp must be non-negative, but was $exp" }
        if (exp == 0) return 1
        var out = 1
        for (i in 1..exp) { out *= this }
        return out
    }
}
