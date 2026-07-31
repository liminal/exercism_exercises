class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(
        val data: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null,
    )

    var root: Node<T>? = null

    fun insert(value: T) {
        if (root == null) {
            root = Node(value)
        } else {
            insertInNode(root!!, value)
        }
    }

    fun insertInNode(node: Node<T>, value: T) {
        if (value <= node.data) {
            if (node.left == null) {
                node.left = Node(value)
            } else {
                insertInNode(node.left!!, value)
            }
        } else {
            if (node.right == null) {
                node.right = Node(value)
            } else {
                insertInNode(node.right!!, value)
            }
        }
    }

    fun asSortedList(): List<T> {
        return sortedList(root)
    }

    fun asLevelOrderList(): List<T> {
        return mutableListOf<MutableList<T>>()
            .also { levelOrderList(root, 0, it) }
            .flatten()
    }

    private fun sortedList(node: Node<T>?): List<T> {
        return if (node == null) {
            emptyList()
        } else {
            sortedList(node.left) + node.data + sortedList(node.right)
        }
    }

    private fun levelOrderList(node: Node<T>?, level: Int, results: MutableList<MutableList<T>>) {
        if (node == null) return
        if (results.size <= level) {
            results.add(ArrayList())
        }

        results[level].add(node.data)

        levelOrderList(node.left, level + 1, results)
        levelOrderList(node.right, level + 1, results)
    }

}
