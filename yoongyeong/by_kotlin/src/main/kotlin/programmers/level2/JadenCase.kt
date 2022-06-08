package programmers.level2

// JadenCase 문자열 만들기

class JadenCase {
    fun solution(s: String): String {
        return s.toLowerCase().split(" ").joinToString(" "){ it.capitalize() }
    }
}