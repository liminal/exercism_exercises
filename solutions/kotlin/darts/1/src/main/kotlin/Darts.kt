object Darts {
    
    fun score(x: Number, y: Number /* choose proper types! */): Int {
        val dist = x.toDouble()*x.toDouble()+y.toDouble()*y.toDouble()
        return when {
            dist <= 1.0 -> 10
            dist <= 25.0 -> 5
            dist <= 100.0 -> 1
            else -> 0
        }
    }
}
