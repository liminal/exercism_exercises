class BankAccount {

    val balance: Long
        @Synchronized
        get() {
            if (isClosed) throw IllegalStateException()
            return _balance
        }

    private var _balance: Long = 0

    private var isClosed: Boolean = false

    @Synchronized
    fun adjustBalance(amount: Long) {
        if (isClosed) {
            throw IllegalStateException()
        }
        _balance += amount
    }

    @Synchronized
    fun close() {
        isClosed = true
    }
}
