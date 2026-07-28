object Acronym {
    fun generate(phrase: String) : String {
        return phrase.split(' ','-',',','_')
            .mapNotNull { it.firstOrNull() }
            .joinToString("") { it.uppercase()}
    }
}
