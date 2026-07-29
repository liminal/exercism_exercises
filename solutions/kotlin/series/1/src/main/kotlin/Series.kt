object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(s.length >= n)
        require(n > 0)
        return s.windowed(n).map { it.map(Char::digitToInt) }
    }
}
