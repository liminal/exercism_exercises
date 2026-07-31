object MatchingBrackets {

    fun isValid(input: String): Boolean {
        val deque = ArrayDeque<Char>()
        for (c in input) {
            if (c == '{' || c == '(' || c == '[') {
                deque.addLast(c)
            }
            if (c == '}' || c == ')' || c == ']') {
                val m = deque.removeLastOrNull()
                if (c == '}' && m != '{') return false
                if (c == ')' && m != '(') return false
                if (c == ']' && m != '[') return false
            }
        }
        return deque.isEmpty()
    }
}
