import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number in 1..64)
        return BigInteger.valueOf(2).pow(number -1)
    }

    fun getTotalGrainCount(): BigInteger {
        return (1..64).map { getGrainCountForSquare(it) }.reduce { acc, integer -> acc + integer }
    }
}
