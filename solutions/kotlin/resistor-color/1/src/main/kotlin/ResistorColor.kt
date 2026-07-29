object ResistorColor {

    enum class ColorCode(val code: Int) {
        black( 0),
        brown( 1),
        red( 2),
        orange( 3),
        yellow( 4),
        green( 5),
        blue( 6),
        violet( 7),
        grey( 8),
        white( 9),

    }

    fun colorCode(input: String): Int {
        return ColorCode.entries.find { it.name == input }?.code ?: -1
    }

    fun colors(): List<String> {
        return ColorCode.entries.map { it.name }
    }

}
