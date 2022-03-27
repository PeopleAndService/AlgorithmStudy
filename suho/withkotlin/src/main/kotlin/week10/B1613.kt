package week10

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1613
문제제목 : 역사
난이도 : 골드 3
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 플로이드-와샬

알고리즘 설명
1. 전후 관계를 true로 나타내는 인접행렬 -> 입력 a b에 대해 a가 b보다 먼저 일어난 사건으로 들어옴. graph[a][b] = true
2. 플로이드 와샬 수행
3. 전후 관계를 찾아본다. -> a, b에 대해 graph[a][b]가 true이면 a가 b보다 먼저 일어남, graph[b][a]가 true이면 b가 a보다 먼저 일어남

채점 결과 : 560ms/35928KB
풀이 날짜 : 2022/03/27
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = with(StringTokenizer(br.readLine())) {
        B1613(nextToken().toInt(), nextToken().toInt())
    }
    inst.input()
    inst.floyd()
    inst.solution()

    bw.close()
    br.close()
}

class B1613(private val n: Int, private val k: Int) {
    private val graph = Array(n + 1) { BooleanArray(n + 1) }

    fun input() {
        repeat(k) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()

                graph[a][b] = true
            }
        }
    }

    fun floyd() {
        for (k in 1..n) {
            for (i in 1..n) {
                if (i == k) continue
                for (j in 1..n) {
                    if (i == j) continue
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true
                    }
                }
            }
        }
    }

    fun solution() {
        val s = br.readLine().toInt()
        repeat(s) {
            val a: Int
            val b: Int
            with(StringTokenizer(br.readLine())) {
                a = nextToken().toInt()
                b = nextToken().toInt()
            }

            when {
                graph[a][b] -> bw.write("-1")
                graph[b][a] -> bw.write("1")
                else -> bw.write("0")
            }
            bw.newLine()
        }
    }
}