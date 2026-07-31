import kotlin.random.Random

class Robot {

    val name: String
        get()  {
        if (_name == null) {
            _name = getNewRobotName()
        }
        return _name!!
    }

    private var _name: String? = null

    fun reset() {
        _name = null
    }

    companion object {

        private val USED_NAMES = mutableSetOf<String>()

        private fun genIdentifier() =
            "" + ('A'+Random.nextInt(26)) +
                    ('A'+Random.nextInt(26)) + Random.nextInt(1000)

        private fun getNewRobotName(): String {
            var name = genIdentifier()
            while (name in USED_NAMES) {
                name = genIdentifier()
            }
            USED_NAMES += name
            return name
        }
    }

}
