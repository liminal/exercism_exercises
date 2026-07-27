fun transcribeToRna(dna: String): String =
    dna.map(::complementNucleotid)
        .joinToString(separator = "")

fun complementNucleotid(ch: Char) : Char =
    when (ch) {
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        'A' -> 'U'
        else -> error("invalid character: $ch")
    }