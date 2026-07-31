object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        if (size == 0) return arrayOf()
        if (size == 1) { return arrayOf(intArrayOf(1)) }

        val spiral = Array(size) { IntArray(size) { 0 } }

        val walker = SpiralWalker(spiral)

        while (walker.step()) {
            // NOOP
        }

        return spiral
    }

    class SpiralWalker(val spiral: Array<IntArray>) {
        var counter = 0
        var position = Point(-1, 0)

        var direction = Point(1 , 0)

        fun step(): Boolean {
            if (!canTakeStep()) {
                direction = direction.turnRight()
                if (!canTakeStep()) {
                    return false
                }
            }
            position += direction

            spiral[position.y][position.x] = ++counter
            return true
        }

        private val spiralRange = spiral.indices

        private fun canTakeStep() : Boolean {
            val nextPos = position + direction
            if (nextPos.x !in spiralRange) return false
            if (nextPos.y !in spiralRange) return false
            return spiral[nextPos.y][nextPos.x] == 0
        }
    }

    data class Point(val x: Int, val y: Int) {
        operator fun plus(other: Point) : Point{
            return Point(x + other.x, y + other.y)
        }

        fun turnRight(): Point =
            Point(-y, x)
    }
}
