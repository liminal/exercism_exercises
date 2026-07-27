object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()
        source.forEach { (point, letters) ->
            letters.forEach { letter ->
                result[letter.lowercaseChar()] = point
            }
        }
        return result
    }
}
