data class Item(val weight: Int, val value: Int)

data class Knapsack(val items: List<Item>) {
    val weight: Int by lazy { items.sumOf { it.weight } }
    val value: Int by lazy { items.sumOf { it.value } }
}

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    val possibleKnapsacks = generateSubsets(items).map { Knapsack(it) }

    return possibleKnapsacks
        .filter { it.weight <= maximumWeight }
        .maxOf { it.value }
}


fun <ITEM> generateSubsets(arr: List<ITEM>): List<List<ITEM>> {
    val result = mutableListOf<List<ITEM>>()

    fun backtrack(start: Int, subset: MutableList<ITEM>) {
        result.add(ArrayList(subset)) // Store current subset
        for (i in start until arr.size) {
            subset.add(arr[i])
            backtrack(i + 1, subset)
            subset.removeAt(subset.size - 1)
        }
    }

    backtrack(0, mutableListOf())
    return result
}
