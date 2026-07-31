class EmptyBufferException : Exception()

class BufferFullException : Exception()

class CircularBuffer<T >(val fixedSize: Int) {

    val buffer : MutableList<T?> = MutableList(fixedSize) { null }

    var startIndex = 0
    var currentSize = 0

    val lastIndex get() = positiveMod(startIndex + currentSize)

    fun read() : T {
        if (currentSize == 0) throw EmptyBufferException()
        val out = buffer[startIndex]
        startIndex = incremented(startIndex)
        currentSize--

        return out!!
    }

    fun write(value: T) {
        if (isFull()) throw BufferFullException()
        buffer[lastIndex] = value
        currentSize++
    }

    fun overwrite(value: T) {
        if (!isFull()) {
            write(value)
        } else {
            buffer[startIndex] = value
            startIndex = incremented(startIndex)
        }
    }

    fun clear() {
        startIndex = 0
        currentSize = 0
    }

    private fun isFull(): Boolean = currentSize == fixedSize

    private fun incremented(index: Int): Int = if (index == buffer.lastIndex) 0 else index + 1

    private fun positiveMod(index: Int): Int = if (index >= buffer.size) index - buffer.size else index

}