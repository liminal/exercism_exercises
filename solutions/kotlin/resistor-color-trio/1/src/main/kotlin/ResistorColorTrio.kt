import kotlin.math.pow

object ResistorColorTrio {

    private infix fun Int.pow(power: Int) : Int {
        return this.toDouble().pow(power.toDouble()).toInt()
    }

    fun text(vararg input: Color): String {
        val ohms = (input[0].ordinal * 10 + input[1].ordinal) * (10 pow input[2].ordinal)

        return when {
            ohms >= 1000000 -> "${ohms / 1000000} megaohms"
            ohms >= 1000 -> "${ohms / 1000} kiloohms"
            else -> "$ohms ohms"
        }
    }
}
