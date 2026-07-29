object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        if (list.isEmpty()) { throw NoSuchElementException() }
        return search(list, 0, list.lastIndex, item)
    }

    fun search(list: List<Int>, lower:Int, upper: Int, item: Int): Int {
        if (lower > upper) throw NoSuchElementException()
        if (lower == upper) {
            if (list[lower] == item) {
                return lower
            } else {
                throw NoSuchElementException()
            }
        }
        val mid = (lower + upper)/2
        val midElt = list[mid]

        return when {
            midElt > item -> search(list, lower, mid -1, item)
            midElt < item -> search(list, mid +1, upper, item)
            else -> mid
        }

    }
}
