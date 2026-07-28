fun translate(rna: String?): List<String> {
    if (rna == null) {
        return emptyList()
    }
    val result = mutableListOf<String>()
    for (i in rna.indices step 3) {
        require(i+3 <= rna.length)
        val codon = rna.substring(i, i + 3)
        val protein = mapCodon(codon)
        if (protein == "STOP") return result
        result.add(protein)
    }
    return result
}

fun mapCodon(codon: String): String {
    return when (codon) {
        "AUG" -> "Methionine"
        "UUU", "UUC" -> "Phenylalanine"
        "UUA", "UUG" -> "Leucine"
        "UCU", "UCC", "UCA", "UCG" -> "Serine"
        "UAU", "UAC" -> "Tyrosine"
        "UGU", "UGC" -> "Cysteine"
        "UGG" -> "Tryptophan"
        "UAA", "UAG", "UGA" -> "STOP"
        else -> throw IllegalArgumentException("Unknown codon: $codon")

    }
}
