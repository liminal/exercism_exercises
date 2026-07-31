class CustomSet(vararg elements: Int) {

    constructor(elements: Collection<Int>) : this(*elements.toIntArray())

    private val elements: MutableList<Int> =
        elements.sorted().distinct().toMutableList()

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return elements.all { it in other.elements }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return this.intersection(other).isEmpty()
    }

    fun contains(other: Int): Boolean {
        return elements.indexOf(other) >= 0
    }

    fun intersection(other: CustomSet): CustomSet {
        return CustomSet(elements.filter { other.contains(it) })
    }

    fun add(other: Int) {
        if (!contains(other)) {
            elements.add(other)
            elements.sort()
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is CustomSet && elements == other.elements
    }

    operator fun plus(other: CustomSet): CustomSet {
        return CustomSet(elements + other.elements)
    }

    operator fun minus(other: CustomSet): CustomSet {
        return CustomSet(elements - other.elements)
    }
}
