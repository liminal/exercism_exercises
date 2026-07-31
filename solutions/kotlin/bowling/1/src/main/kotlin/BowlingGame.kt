import BowlingGame.Frame.*

class BowlingGame {

    sealed interface Frame {
        object Strike : Frame
        data class Spare(val roll: Int) : Frame
        data class OpenFrame(val roll1: Int, val roll2: Int) : Frame
    }

    private val frames: MutableList<Frame> = mutableListOf()

    private var lastRoll = -1

    private val tenthFrame get() = frames.getOrNull(9)
    private val bonusFrame get() = frames.getOrNull(10)

    fun roll(pins: Int) {
        if (pins !in 0..10) throw IllegalStateException("a roll can only score between 0 and 10 pins")
        if (frames.size >= 10 + fillFrames()) throw IllegalStateException("There are no frames left")
        if (lastRoll != -1 && lastRoll + pins > 10) throw IllegalStateException("a roll can not score more than 10 pins")

        when {
            lastRoll != -1 -> {
        
                frames += if (lastRoll + pins == 10) {
                    Spare(lastRoll)
                } else {
                    OpenFrame(lastRoll, pins)
                }
                lastRoll = -1

            }

            pins == 10 -> frames += Strike
            tenthFrame is Spare -> {
                frames += OpenFrame(pins, 0)
            }

            bonusFrame is Strike -> {
                frames += OpenFrame(pins, 0)
            }

            else -> lastRoll = pins
        }
    }

    fun score(): Int {
        if (frames.size < 10 + fillFrames())
            throw IllegalStateException("Game not finished")
        return (0 until 10)
            .sumOf { scoreFrame(it) }
    }

    private fun fillFrames(): Int {
        return when (tenthFrame) {
            null -> 0
            is OpenFrame -> 0
            is Spare -> 1
            Strike -> if (bonusFrame is Strike) 2 else 1
        }
    }

    private fun scoreFrame(frameNr: Int): Int {
        return when (val frame = frames[frameNr]) {
            is OpenFrame -> frame.roll1 + frame.roll2
            is Spare -> 10 + nextRolls(frameNr).first
            Strike -> nextRolls(frameNr).let { 10 + it.first + it.second }
        }
    }

    private fun nextRolls(frameNr: Int): Pair<Int, Int> {
        return when (val nextFrame = frames[frameNr + 1]) {
            is OpenFrame -> Pair(nextFrame.roll1, nextFrame.roll2)
            is Spare -> Pair(nextFrame.roll, 10 - nextFrame.roll)
            Strike ->
                when (val nextNextFrame = frames.getOrNull(frameNr + 2)) {
                    is OpenFrame -> Pair(10, nextNextFrame.roll1)
                    is Spare -> Pair(10, nextNextFrame.roll)
                    Strike -> Pair(10, 10)
                    null -> Pair(10, 0)
                }
        }

    }
}
