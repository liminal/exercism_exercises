enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <T> List<T>.relationshipTo(other: List<T>) : Relationship {
    if (isEqual(this, other)) return Relationship.EQUAL
    if (isSublistOf(this, other )) return Relationship.SUBLIST
    if (isSublistOf(other, this )) return Relationship.SUPERLIST
    return Relationship.UNEQUAL
}

fun <T> isEqual(first: List<T>, second: List<T>) : Boolean {
    return when {
        first.size != second.size -> false
        first.isEmpty() -> true
        else -> first.indices.all { second[it] == first[it] }
    }
}

fun <T> isSublistOf(first: List<T>, second: List<T>) : Boolean {
    if (first.isEmpty()) return true
    if (first.size >= second.size) return false
    val sublistSize = first.size
    val lastPossibleIndex = second.size - sublistSize
    for (i in 0..lastPossibleIndex) {
        if (isEqual(first, second.subList(i, i + sublistSize))) return true
    }
    return false
}