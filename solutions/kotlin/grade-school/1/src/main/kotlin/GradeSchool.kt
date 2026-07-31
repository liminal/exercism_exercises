class School {

    val map = mutableMapOf<String, Int>()

    fun add(student: String, grade: Int) {
        map[student] = grade
    }

    fun grade(grade: Int): List<String> {
        return map.entries.filter { it.value == grade }.map { it.key }.sorted()
    }

    fun roster(): List<String> {
        return map.entries.sortedWith(compareBy<MutableMap.MutableEntry<String, Int>> { it.value }.thenBy { it.key }).map { it.key }
    }
}
