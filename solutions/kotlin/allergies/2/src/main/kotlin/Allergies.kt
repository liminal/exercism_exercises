class Allergies(val score: Int) {
    // TODO: implement proper constructor to complete the task

    fun getList(): List<Allergen> {
        return Allergen.entries.filter { isAllergicTo(it) }
    }

    fun isAllergicTo(allergen: Allergen) : Boolean {
        return allergen.score and score == allergen.score
    }
}
