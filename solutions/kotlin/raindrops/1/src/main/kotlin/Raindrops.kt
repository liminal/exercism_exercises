object Raindrops {

    fun convert(n: Int): String {
        val sb = StringBuilder()
        if (n % 3 == 0) sb.append("Pling")
        if (n % 5 == 0) sb.append("Plang")
        if (n % 7 == 0) sb.append("Plong")
        if (n % 3 != 0 && n % 5 != 0 && n % 7 != 0) sb.append("$n")
        return sb.toString()
    }
}
