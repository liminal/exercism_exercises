
fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val out = ArrayList<T>(this)
    list.forEach { out.add(it) }
    return out
}

fun List<Any>.customConcat(): List<Any> {
    if (this.isEmpty()) return emptyList()
    val out = mutableListOf<Any>()
    for (element in this) {
        if (element is List<*>) {
            for (elt in (element as List<Any>).customConcat()) {
                out.add(elt)
            }
        } else {
            out.add(element)
        }
    }
    return out
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    if (this.isEmpty()) return emptyList()
    val out = mutableListOf<T>()
    for (elt in this) {
        if (predicate(elt)) { out.add(elt) }
    }
    return out
}

val List<Any>.customSize: Int get() {
    var i =0
    forEach { _ -> i++ }
    return i
}


fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    if (this.isEmpty()) return emptyList()
    val out = mutableListOf<U>()
    for (elt in this) {
         out.add(transform(elt))
    }
    return out
}

fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U {
    var acc = initial
    for (elt in this) {
        acc = f(acc, elt)
    }
    return acc
}

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    var acc = initial
    for (elt in this.customReverse()) {
        acc = f(elt, acc)
    }
    return acc
}

fun <T> List<T>.customReverse(): List<T> {
    if (this.isEmpty()) return emptyList()
    val out = mutableListOf<T>()
    for (elIdx in lastIndex downTo 0) {
        out.add(this[elIdx])
    }
    return out
}
