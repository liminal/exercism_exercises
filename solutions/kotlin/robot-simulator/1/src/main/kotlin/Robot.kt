class Robot(
    initialPosition: GridPosition = GridPosition(0, 0),
    initialOrientation: Orientation = Orientation.NORTH,
) {

    var gridPosition = initialPosition
    var orientation = initialOrientation

    fun simulate(instructions: String) {
        instructions.forEach { performInstruction(it) }
    }

    private fun performInstruction(instruction: Char) {
        when (instruction) {
            'R' -> turnRight()
            'L' -> turnLeft()
            'A' -> advance()
        }
    }

    private fun turnRight() {
        orientation = when (orientation) {
            Orientation.NORTH -> Orientation.EAST
            Orientation.EAST -> Orientation.SOUTH
            Orientation.SOUTH -> Orientation.WEST
            Orientation.WEST -> Orientation.NORTH
        }
    }

    private fun turnLeft() {
        orientation = when (orientation) {
            Orientation.NORTH -> Orientation.WEST
            Orientation.EAST -> Orientation.NORTH
            Orientation.SOUTH -> Orientation.EAST
            Orientation.WEST -> Orientation.SOUTH
        }
    }

    private fun advance() {
        gridPosition +=
            when (orientation) {
                Orientation.NORTH -> GridPosition(0, 1)
                Orientation.EAST -> GridPosition(1, 0)
                Orientation.SOUTH -> GridPosition(0, -1)
                Orientation.WEST -> GridPosition(-1, 0)
            }
    }

    private operator fun GridPosition.plus(other: GridPosition): GridPosition {
        return GridPosition(x + other.x, y + other.y)
    }
}
