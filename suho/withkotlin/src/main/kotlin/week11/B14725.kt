package week11

import java.util.*

/*
플랫폼 : 백준
문제번호 : 14725
문제제목 : 개미굴
난이도 : 골드 2
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 문자열, 트리, 트라이

알고리즘 설명
문자가 아닌 문자열을 담는 트라이 구성

채점 결과 : 164ms/15264KB
풀이 날짜 : 2022/04/03
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = B14725(br.readLine().toInt())
    inst.input()
    inst.print(inst.root, 1)
    bw.close()
    br.close()
}

private class B14725(
    private val n: Int,
    val root: Node = Node()
) {
    class Node(val child: SortedMap<String, Node> = sortedMapOf<String, Node>())

    fun input() {
        repeat(n) {
            with(StringTokenizer(br.readLine())) {
                val count = nextToken().toInt()
                val strs = mutableListOf<String>().apply {
                    for (i in 0 until count) {
                        add(nextToken())
                    }
                }

                insert(strs)
            }
        }
    }

    private fun insert(strings: MutableList<String>) {
        var cur = root

        for (str in strings) {
            cur = cur.child[str] ?: run {
                cur.child[str] = Node()
                cur.child[str]!!
            }
        }
    }

    fun print(cur: Node, depth: Int) {
        for (key in cur.child.keys) {
            for (i in 1 until depth) {
                bw.write("--")
            }
            bw.write(key)
            bw.newLine()
            print(cur.child[key]!!, depth + 1)
        }
    }
}