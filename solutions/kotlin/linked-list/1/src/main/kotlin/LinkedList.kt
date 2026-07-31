class Deque<T> {

    var first: Node<T>? = null
    var last: Node<T>? = null

    data class Node<T>(
        var value: T,
        var prev: Node<T>? = null,
        var next: Node<T>? = null,
    )

    fun push(value: T) {
        addFirst(value)
    }

    fun pop(): T? = removeFirst()

    fun unshift(value: T) {
        addLast(value)
    }

    fun shift(): T? = removeLast()

    // If you're unsure which one adds at the start and which one adds at the end implement
    // them as addFirst, addLast, removeFirst, removeLast first. It helps to keep things straight :)

    private fun addFirst(value: T) {
        val f = first
        val newNode = Node(value, prev= null, next = f)
        first = newNode
        if (f == null) {
            last = newNode
        } else {
            f.prev = newNode
        }
    }

    private fun removeFirst() : T? {
        val f = first ?: throw NoSuchElementException()
        val element = f.value
        val next = f.next
        f.next = null
        first = next
        if (next == null) {
            last = null
        } else {
            next.prev = null
        }
        return element
    }


    private fun addLast(value: T) {
        val l = last
        val newNode = Node(value, prev = l, next = null)
        last = newNode
        if (l == null) {
            first = newNode
        } else {
            l.next = newNode
        }
    }

    private fun removeLast(): T? {
        val l = last ?: throw NoSuchElementException()
        val element = l.value
        val prev = l.prev
        l.prev = null
        last = prev
        if (prev == null) {
            first = null
        } else {
            prev.next = null
        }
        return element
    }

}
