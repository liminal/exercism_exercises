class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        val x = a.toDouble()
        val y = b.toDouble()
        val z = c.toDouble()
        require(x > 0 && y > 0 && z > 0)
        require(x + y >= z)
        require(y + z >= x)
        require(x + z >= y)
    }

    val isEquilateral: Boolean get() = a == b && b == c
    val isIsosceles: Boolean get() =  !isScalene
    val isScalene: Boolean get() = a != b && b != c && c != a
}