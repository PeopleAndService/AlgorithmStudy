package week9

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1976
문제제목 : 여행 가자
난이도 : 골드 4
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 자료 구조, 분리 집합

알고리즘 설명
1. 도시가 서로 연결되어있다면 union 연산
2. 여행 코스에 대해서 도시의 find 연산 결과가 모두 같다면(같은 집합에 속해있는 도시) 여행 가능한 코스

채점 결과 : 148ms/16496KB
풀이 날짜 : 2022/03/20
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val parent = Parent(n)

    for (i in 1..n) {
        with(StringTokenizer(br.readLine())) {
            for (j in 1..n) {
                val isLink = nextToken().toInt()
                if (isLink == 1) parent.union(i, j)
            }
        }
    }

    val flag = with(StringTokenizer(br.readLine())) {
        val first = parent.find(nextToken().toInt())

        for (i in 1 until m) {
            val next = nextToken().toInt()
            if (first != parent.find(next)) return@with false
        }

        return@with true
    }

    bw.write(if (flag) "YES" else "NO")
    bw.close()
    br.close()
}

private class Parent(n: Int) {
    private val parents = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        return if (x == parents[x]) x
        else {
            parents[x] = find(parents[x])
            parents[x]
        }
    }

    fun union(a: Int, b: Int) {
        val aP = find(a)
        val bP = find(b)

       if (aP != bP) {
           if (aP < bP) parents[bP] = aP
           else parents[aP] = bP
       }
    }
}
