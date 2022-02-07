package week3

import java.util.*
import kotlin.math.abs
import kotlin.math.min

/*
플랫폼 : 백준
문제번호 : 14889
문제제목 : 스타트와 링크
난이도 : 실버 2
제한사항 : 2초/512MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
1. visit 배열로 조합 구분(true끼리 한 팀, false끼리 한 팀)
2. 조합 알고리즘으로 조합 구하고
3. 능력치 점수 계산 -> calcStat() 함수
4. 최소값 갱신
5. 조합 구하는 중에 최소값이 0인 경우 바로 리턴

채점 결과 : 308ms/14708KB
풀이 날짜 : 2022/02/06
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var stats: Array<IntArray>
private lateinit var visit: BooleanArray
private var answer = Int.MAX_VALUE

fun main() {
    n = br.readLine().toInt()
    stats = Array(n) { StringTokenizer(br.readLine()).run {
        IntArray(n) { nextToken().toInt() }
    }}
    visit = BooleanArray(n)
    makeComb(0, 0)
    bw.write("$answer")
    bw.close()
    br.close()
}

private fun makeComb(depth: Int, index: Int) {
    if (answer == 0) return

    if (depth == n / 2) {
        answer = min(answer, calcStat())
        return
    }

    for (i in index until n) {
        visit[index] = true
        makeComb(depth + 1, i + 1)
        visit[index] = false
    }
}

private fun calcStat(): Int {
    var start = 0
    var link = 0

    for (i in 0 until n-1) {
        for (j in i+1 until n) {
            if (visit[i] && visit[j]) {
                start += stats[i][j] + stats[j][i]
            } else if (!visit[i] && !visit[j]) {
                link += stats[i][j] + stats[j][i]
            }
        }
    }

    return abs(start - link)
}