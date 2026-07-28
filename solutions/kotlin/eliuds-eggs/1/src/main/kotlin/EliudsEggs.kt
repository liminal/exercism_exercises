object EliudsEggs {

    fun eggCount(number: Int): Int{

        // Noone said it had to be efficient :)
        return Integer.toBinaryString(number).count { it == '1' }
    }
}
