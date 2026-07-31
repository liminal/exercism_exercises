class KindergartenGarden(private val diagram: String) {

    private val Char.plant get() : String =
        when (this) {
            'G' -> "grass"
            'C' -> "clover"
            'R' -> "radishes"
            'V' -> "violets"
            else -> error("unknown Char $this")
        }

    fun getPlantsOfStudent(student: String): List<String> {
        val i = student[0] - 'A'
        val rows = diagram.split('\n')
        return listOf(
            rows[0][i*2].plant,
            rows[0][i*2 +1].plant,
            rows[1][i*2 ].plant,
            rows[1][i*2 +1].plant,
        )

    }
}
