object RunLengthEncoding {

    fun encode(input: String): String {
        if (input.isEmpty()) return ""
        val sb = StringBuilder()
        var count = 1
        var currChar: Char = input[0]
        for (ch in input.toCharArray().drop(1)) {
            if (ch != currChar) {
                if (count > 1) {
                    sb.append(count)
                }
                sb.append(currChar)

                count = 1
                currChar = ch
            } else {
                count++
            }
        }
        if (count > 1) {
            sb.append(count)
        }
        sb.append(currChar)
        return sb.toString()
    }

    fun decode(input: String): String {
        if (input.isEmpty()) return ""
        val sb = StringBuilder()
        var count = 0
        for (ch in input.toCharArray()) {
            if (ch in '0'..'9') {
                count = count * 10 + (ch - '0')
            } else {
                if (count > 0) {
                    sb.append("$ch".repeat(count))
                } else {
                    sb.append(ch)
                }
                count = 0
            }
        }
        return sb.toString()
    }
}
