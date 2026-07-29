object Isogram {

    fun isIsogram(input: String): Boolean {
        val letters = mutableSetOf<Char>()
        for (c in input.lowercase()) {
            if (c in letters) return false
            if (c != ' ' && c != '-')
                letters.add(c)
        }
        return true
    }

}
