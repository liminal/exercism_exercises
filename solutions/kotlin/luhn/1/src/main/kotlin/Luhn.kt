object Luhn {

    fun isValid(candidate: String): Boolean {
        val despaced = candidate.replace(" ", "")
        if(!despaced.all { it.isDigit() }) return false
        if(despaced.length <= 1) return false
        return despaced
            .map { it.digitToInt()}
            .reversed()
            .mapIndexed { index, d -> if (index % 2 == 1) {
                if (d * 2 > 9) {
                    d * 2 - 9
                } else {
                    d * 2
                }
            } else d
            }.sum() % 10 == 0
    }
}
