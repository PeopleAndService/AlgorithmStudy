package week9

import java.util.LinkedList
import java.util.StringTokenizer

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

/*
플랫폼 : 백준
문제번호 : 1005
문제제목 : ACM Craft
난이도 : 골드 3
제한사항 : 1초/512MB
알고리즘 분류 : DP, 그래프 이론, 위상 정렬

알고리즘 설명
위상 정렬 알고리즘 -> 입력 그래프가 방향을 갖고 사이클이 없음
대신 노드의 순서가 아닌 건설 소요 시간을 저장

채점 결과 : 868ms/242856KB
풀이 날짜 : 2022/03/26
*/

fun main() {
    repeat(br.readLine().toInt()) {
        val inst = with(StringTokenizer(br.readLine())) {
            B1005(nextToken().toInt(), nextToken().toInt())
        }
        inst.input()
        val answer = inst.tpSort()
        bw.write("$answer\n")
    }
    bw.close()
    br.close()
}

class B1005(private val n: Int, private val k: Int) {
    private val d = IntArray(n + 1)
    private val graph = Array(n + 1) { mutableListOf<Int>() }
    private val inDegree = IntArray(n + 1)

    fun input() {
        with(StringTokenizer(br.readLine())) {
            repeat(n) {
                d[it+1] = nextToken().toInt()
            }
        }

        for (i in 0 until k) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()

                graph[a].add(b)
                inDegree[b]++
            }
        }
    }

    fun tpSort(): Int {
        val target = br.readLine().toInt()

        val queue = LinkedList<Int>()
        val result = d.clone()

        for (i in 1..n) {
            if (inDegree[i] == 0) queue.offer(i)
        }

        while (queue.isNotEmpty()) {
            val cur = queue.poll()

            for (next in graph[cur]) {
                result[next] = maxOf(result[next], result[cur] + d[next])
                inDegree[next]--

                if (inDegree[next] == 0) {
                    queue.offer(next)
                }
            }
        }

        return result[target]
    }
}