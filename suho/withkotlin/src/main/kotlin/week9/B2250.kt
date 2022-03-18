package week9

import java.util.*

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

/*
플랫폼 : 백준
문제번호 : 2250
문제제목 : 트리의 높이와 너비
난이도 : 골드 2
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 트리, DFS

알고리즘 설명
핵심: 각 노드의 열번호를 차례로 읽어보면 중위 순회 순서와 같음
입력에 루트 노드가 주어지지 않기 때문에 부모 노드 정보를 담을 배열이 필요 -> 부모가 0이면 루트임
트리 구조는 Node 배열로 만든다. tree[node번호] = Node(왼쪽 자식 번호, 오른쪽 자식 번호)
루트를 찾아서 중위 순회 수행 -> 루트 노드의 순회 시에 각 레벨별로 왼쪽 최소 열 번호와 오른쪽 최대 열 번호를 갱신
루트 순회: 열 번호 + 1, 레벨은 1부터 최대 n까지 가능 (한 쪽으로 치우친 이진 트리)
마지막으로 각 레벨별로 최대 길이 갱신

채점 결과 : 200ms/19088KB
풀이 날짜 : 2022/03/17
*/

fun main() {
    val n = br.readLine().toInt()
    val inst = B2250(n)
    inst.input()
    val (level, width) = inst.solution()

    bw.write("$level $width")
    bw.close()
    br.close()
}

class B2250(private val n: Int) {
    private data class Node(
        val left: Int = -1,
        val right: Int = -1
    )

    private val tree = Array(n + 1) { Node() }
    private val parent = IntArray(n + 1)
    private val leftCol = IntArray(n + 1) { n }
    private val rightCol = IntArray(n + 1)
    private var colCount = 1

    fun input() {
        repeat(n) {
            with(StringTokenizer(br.readLine())) {
                val num = nextToken().toInt()
                val left = nextToken().toInt()
                val right = nextToken().toInt()

                if (left != -1) parent[left] = num
                if (right != -1) parent[right] = num
                tree[num] = Node(left, right)
            }
        }
    }

    private fun getRoot(): Int {
        for (i in 1..n) {
            if (parent[i] == 0) return i
        }
        return 0
    }

    fun solution(): Pair<Int, Int> {
        val root = getRoot()
        inOrder(root, 1)

        var level = 1
        var width = 1
        for (l in 1..n) {
            val length = rightCol[l] - leftCol[l] + 1
            if (length > width) {
                level = l
                width = length
            }
        }

        return level to width
    }

    private fun inOrder(node: Int, level: Int) {
        val cur = tree[node]

        if (cur.left != -1) inOrder(cur.left, level + 1)

        leftCol[level] = minOf(leftCol[level], colCount)
        rightCol[level] = maxOf(rightCol[level], colCount)
        colCount++

        if (cur.right != -1) inOrder(cur.right, level + 1)
    }
}