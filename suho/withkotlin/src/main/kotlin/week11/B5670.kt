package week11

/*
플랫폼 : 백준
문제번호 : 5670
문제제목 : 휴대폰 자판
난이도 : 플래티넘 4
제한사항 : 1초/192MB
알고리즘 분류 : 자료 구조, 문자열, 트리, 트라이

알고리즘 설명
1. 트라이에 문자열을 집어넣고
2. 문자열마다 버튼 클릭 횟수를 세준다.
사용자가 버튼을 눌러야할 때: 문자열의 유일한 마지막 문자가 아니고, 다른 단어의 마지막 문자이거나 해당 문자 다음에 문자가 2개 이상 오는 경우 사용자가 눌러서 입력

채점 결과 : 1008ms/214428KB
풀이 날짜 : 2022/04/06
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var n = br.readLine()

    while (!n.isNullOrBlank()) {
        val trie = B5670(n.toInt())
        bw.write(trie.solution())
        bw.newLine()
        n = br.readLine()
    }

    bw.close()
    br.close()
}

private class B5670(
    private val n: Int,
    private val root: Node = Node()
) {
    private var words = Array<String>(n) {
        br.readLine().also {
            var cur = root
            it.forEach { ch ->
                cur = cur.child.getOrPut(ch) { Node() }
            }
            cur.isLeaf = true
        }
    }

    class Node(
        val child: MutableMap<Char, Node> = mutableMapOf(),
        var isLeaf: Boolean = false
    )

    fun solution(): String {
        var sum = 0
        words.forEach {
            sum += buttonCount(it)
        }

        return String.format("%.2f", sum.toDouble() / n)
    }

    private fun buttonCount(word: String): Int {
        var cur = root
        var count = 1

        for ((idx, ch) in word.withIndex()) {
            cur = cur.child[ch]!!

            if (idx != word.lastIndex && (cur.isLeaf || cur.child.size >= 2)) count++
        }

        return count
    }
}