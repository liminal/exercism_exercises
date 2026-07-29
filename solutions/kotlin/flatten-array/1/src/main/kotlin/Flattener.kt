object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        val output = mutableListOf<Any>()
        source.forEach { flattenTo(output, it)}
        return output
    }

    private fun flattenTo(output: MutableList<Any>, target: Any?) {
        if (target is Collection<*>) {
            target.forEach { flattenTo(output, it) }
        } else if (target != null){
            output.add(target)
        }
    }
}
