package week9

import java.io.BufferedWriter
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 10159
문제제목 : 저울
난이도 : 골드 3
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 플로이드-와샬

알고리즘 설명
1. 크기 관계는 단방향 그래프 -> <관계와 >관계를 따로 만들어준다.
2. 두 관계 그래프에 대해서 플로이드
3. 두 관계 그래프의 값을 or 연산했을 때 1이면 대소 비교가 가능한 관계

채점 결과 : 140ms/13412KB
풀이 날짜 : 2022/03/25
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = run {
        B10159(br.readLine().toInt(), br.readLine().toInt())
    }

    inst.input()
    inst.floyd()
    inst.solution(bw)

    bw.close()
    br.close()
}

class B10159(private val n: Int, private val m: Int) {
    private val greaterThenGraph = Array(n + 1) { IntArray(n + 1) } // x > y
    private val lessThenGraph = Array(n + 1) { IntArray(n + 1) } // x < y

    fun input() {
        repeat(m) {
            with(StringTokenizer(br.readLine())) {
                val x = nextToken().toInt()
                val y = nextToken().toInt()

                greaterThenGraph[x][y] = 1
                lessThenGraph[y][x] = 1
            }
        }
    }

    fun floyd() {
        for (k in 1..n) {
            for (i in 1..n) {
                if (i == k) continue
                for (j in 1..n) {
                    if (j == i) continue
                    if (greaterThenGraph[i][k].and(greaterThenGraph[k][j]) == 1) {
                        greaterThenGraph[i][j] = 1
                    }

                    if (lessThenGraph[i][k].and(lessThenGraph[k][j]) == 1) {
                        lessThenGraph[i][j] = 1
                    }
                }
            }
        }
    }

    fun solution(bw: BufferedWriter) {
        for (i in 1..n) {
            for (j in 1..n) {
                greaterThenGraph[i][j] = greaterThenGraph[i][j].or(lessThenGraph[i][j])
            }
        }

        for (i in 1..n) {
            val count = greaterThenGraph[i].filterIndexed { index, num -> index in 1..n && index != i && num == 0 }.count()
            bw.write("$count\n")
        }
    }
}