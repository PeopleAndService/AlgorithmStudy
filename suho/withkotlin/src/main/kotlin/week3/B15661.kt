package week3

import java.util.*
import kotlin.math.abs
import kotlin.math.min

/*
플랫폼 : 백준
문제번호 : 15661
문제제목 : 링크와 스타트
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
스타트와 링크(14899) 문제와 비슷한 문제지만 이 문제는 팀 구성원 숫자를 다르게 해도 된다. 단, 최소 1명
처음에 주석 코드로 풀었는데 시간초과가 났다. -> 백트래킹을 하는 상태공간트리의 분기가 너무 많이 일어남. 불필요한 반복이 수행
따라서 depth를 팀 구성원 수로 취급하고 n까지 진행한다 -> 첫 재귀는 n명과 0명의 팀으로 나뉘겠지만 이는 어짜피 최소값이 아니므로 무시됌
다음 재귀부터는 false인 팀이 한 명씩 늘어나고, 각 상태는 정확히 두 개의 다음 상태를 만들어낸다.
각 노드에서 depth 사람을 true팀으로, false팀으로 두는 다음 상태 분기를 시작

채점 결과 : 688ms/15968KB
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

    makeComb(0)

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun makeComb(depth: Int) {
    if (answer == 0) return

    if (depth == n) {
        answer = min(answer, calcStat())
        return
    }

    visit[depth] = true
    makeComb(depth + 1)
    visit[depth] = false
    makeComb(depth + 1)
}

/*private fun makeComb(depth: Int, index: Int, m: Int) {
    if (answer == 0) return

    if (depth == m) {
        answer = min(answer, calcStat())
        return
    }

    for (i in index until n) {
        visit[i] = true
        makeComb(depth + 1, index + 1, m)
        visit[i] = false
    }
}*/

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