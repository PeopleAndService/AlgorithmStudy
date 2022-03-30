package week10

import java.util.LinkedList
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 2623
문제제목 : 음악프로그램
난이도 : 골드 2
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 위상 정렬

알고리즘 설명
위상 정렬 수행
불가능한 경우는 사이클이 발생한 경우 -> 순서 리스트의 크기가 n이 아닌 경우

채점 결과 : 160ms/20556KB
풀이 날짜 : 2022/03/30
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)
    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val count = nextToken().toInt()
            var a = nextToken().toInt()

            repeat(count - 1) {
                val b = nextToken().toInt()
                graph[a].add(b)
                inDegree[b]++
                a = b
            }
        }
    }

    val queue = LinkedList<Int>()
    for (i in 1..n) {
        if (inDegree[i] == 0) {
            queue.offer(i)
        }
    }

    val answer = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        answer.add(cur)

        graph[cur].forEach {
            inDegree[it]--
            if (inDegree[it] == 0) queue.offer(it)
        }
    }

    if (answer.size != n) {
        answer.clear()
        answer.add(0)
    }

    bw.write(answer.joinToString("\n"))
    bw.close()
    br.close()
}