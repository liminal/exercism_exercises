object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when (category) {
            YachtCategory.ONES -> dices.filter { it == 1 }.sum()
            YachtCategory.TWOS -> dices.filter { it == 2 }.sum()
            YachtCategory.THREES -> dices.filter { it == 3 }.sum()
            YachtCategory.FOURS -> dices.filter { it == 4 }.sum()
            YachtCategory.FIVES -> dices.filter { it == 5 }.sum()
            YachtCategory.SIXES -> dices.filter { it == 6 }.sum()
            YachtCategory.FULL_HOUSE -> {
                val pair = sumOfCount(dices, 2)
                val trips = sumOfCount(dices, 3)
                if (pair == 0 || trips == 0) 0 else pair + trips
            }
            YachtCategory.FOUR_OF_A_KIND -> {
                if (dices.all { it == dices.first() }) {
                    dices.first() * 4
                } else {
                    sumOfCount(dices, 4)
                }
            }
            YachtCategory.LITTLE_STRAIGHT -> if(dices.toSet() == setOf(1,2,3,4,5)) 30 else 0
            YachtCategory.BIG_STRAIGHT -> if(dices.toSet() == setOf(2,3,4,5,6)) 30 else 0
            YachtCategory.CHOICE -> dices.sum()
            YachtCategory.YACHT -> if (dices.all { it == dices.first() }) 50 else 0
        }
    }

    private fun sumOfCount(dices: IntArray, count: Int) : Int {
        val sumMap = mutableMapOf<Int,Int>()
        for (d in dices) {
            sumMap[d] = sumMap.getOrDefault(d,0)+1
        }
        return sumMap.entries.find { (side, c) -> c == count }
            ?.let { (side, c) -> side * c } ?: 0
    }
}
