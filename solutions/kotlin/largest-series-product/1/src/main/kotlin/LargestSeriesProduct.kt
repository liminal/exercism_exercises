class Series(val input: String) {

    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 1) { "span must be greater than or equal to 1" }
        require(span <= input.length) { "span must be less than or equal to input length" }
        return input.windowed(span).maxOf(::digitProduct)
    }

    private fun digitProduct(str: String): Long {
        return str.map { c -> c.digitToInt() }
            .reduce { acc, i -> acc * i }
            .toLong()
    }
}
