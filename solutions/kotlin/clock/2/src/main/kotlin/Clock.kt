class Clock(hours: Int, minutes: Int) {

    val hours : Int get() = internalMinutes / 60
    val minutes: Int get() = internalMinutes % 60

    var internalMinutes: Int

    val MINUTES_IN_A_DAY = 24*60
    init {
        internalMinutes= moduloMinutes(hours * 60 + minutes)
    }

    private fun moduloMinutes(minutes: Int): Int {
        return ((minutes % MINUTES_IN_A_DAY) + MINUTES_IN_A_DAY) % MINUTES_IN_A_DAY
    }

    override fun toString(): String = "%02d:%02d".format(hours, minutes)

    override fun equals(other: Any?): Boolean {
        return internalMinutes == (other as? Clock)?.internalMinutes
    }

    override fun hashCode(): Int = internalMinutes

    fun subtract(minutes: Int) {
        internalMinutes = moduloMinutes(internalMinutes - minutes)
    }

    fun add(minutes: Int) {
        internalMinutes = moduloMinutes(internalMinutes + minutes)
    }
}
