object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        require(leftStrand.length == rightStrand.length)
        var d = 0
        for (i in leftStrand.indices) {
            if (leftStrand[i] != rightStrand[i]) d +=1
        }
        return d
    }
}
