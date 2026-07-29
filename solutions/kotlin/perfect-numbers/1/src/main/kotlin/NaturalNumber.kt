
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun aliquotSum(naturalNumber: Int) : Int {
    require(naturalNumber > 0)
    return (1 until naturalNumber)
        .filter { naturalNumber % it == 0 }
        .sum()
}

fun classify(naturalNumber: Int): Classification {
    val asum = aliquotSum(naturalNumber)
    return when {
        asum < naturalNumber -> Classification.DEFICIENT
        asum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.PERFECT
    }
}
