class PhoneNumber(number: String) {

    val punctuation = "[- +)(.]".toRegex()

    val number: String?
    init {
        val normalized = number.replace(punctuation, "")
        val n = if (normalized.length == 11 && normalized[0] == '1') {
            normalized.substring(1)
        } else normalized
        require(n.length == 10)
        require(n.all { it.isDigit() })
        require(n[0] in '2'..'9')
        require(n[3] in '2'..'9')

        this.number = n
    }

}
