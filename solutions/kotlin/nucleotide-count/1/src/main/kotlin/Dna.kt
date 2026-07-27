class Dna(val dna: String) {

    init {
        dna.forEach { requireValidNucleotide(it) }
    }
    fun requireValidNucleotide(ch: Char)  =
        require(ch == 'A' || ch == 'C' || ch == 'G' || ch == 'T')

    val nucleotideCounts: Map<Char, Int>
        get() {
            val m = mutableMapOf<Char, Int>('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
            dna.forEach { ch ->
                m[ch] = m[ch]!! + 1
            }

            return m
        }
}
