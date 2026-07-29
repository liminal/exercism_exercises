object HandshakeCalculator {
    private fun Int.hasBit(n: Int): Boolean =
        this and (1 shl n) != 0

    fun calculateHandshake(number: Int): List<Signal> {
        val output = mutableListOf<Signal>()
        if (number.hasBit(0)) output.add(Signal.WINK)
        if (number.hasBit(1)) output.add(Signal.DOUBLE_BLINK)
        if (number.hasBit(2)) output.add(Signal.CLOSE_YOUR_EYES)
        if (number.hasBit(3)) output.add(Signal.JUMP)
        return if (number.hasBit(4)) {
            output.reversed()
        } else {
            output.toList()
        }
    }
}
