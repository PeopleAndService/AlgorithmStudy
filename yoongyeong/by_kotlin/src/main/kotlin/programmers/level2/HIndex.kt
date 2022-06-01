package programmers.level2

class HIndex {
    fun solution(citations: IntArray): Int {
        val sortCitations = citations.sortedDescending()
        for ((i, citation) in sortCitations.withIndex()) {
            if (citation <= i) {
                return i
            }
        }
        return citations.size
    }
}