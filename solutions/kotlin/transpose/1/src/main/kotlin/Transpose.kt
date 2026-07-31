object Transpose {

    fun transpose(input: List<String>): List<String> {
        if (input.isEmpty()) return emptyList()
        val out = mutableListOf<String>()
        val ow = input.maxOf { it.length }
        val oh = input.size
        for (y in 0 until ow) {
            val sb = StringBuilder()
            for (x in 0 until oh) {
                if (y > input[x].lastIndex ) {
                    sb.append("¤")
                } else {
                    val ch = input[x][y]
                    print("[$x,$y]:$ch ")
                    sb.append(ch)
                }
            }
            out.add(sb.toString().trimEnd('¤').replace('¤', ' '))
        }
        return out
    }
}
