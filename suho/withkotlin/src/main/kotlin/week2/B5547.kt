package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*
플랫폼 : 백준
문제번호 : 5547
문제제목 : 일루미네이션
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS, DFS

알고리즘 설명
건물 외벽에 대한 조명 설치 벽의 개수를 알아야함
4방향이 아닌 6각형의 각 변 탐색 -> 또 홀수 행과 짝수 행에서 탐색 방향이 다름
1. 내벽(1로 둘러싸인 0)에 대해서는 볼 필요가 없음
2. 테두리에서 건물이 없는(0) 위치에서 dfs를 하면서 인접한 0을 따라가면서 건물(1)과 맞닿은 변의 개수를 체크
3. 또 각 테두리에 따라서 건물인 위치(1)에서 테두리에 설치되는 조명 벽의 개수가 다름
3.1 첫 번째 행 맨 왼쪽과 맨 오른쪽은 벽이 1개 나머지는 벽이 2개, 마지막 행도 마찬가지
3.2 첫 번째 열 홀수행과 마지막열 짝수행은 벽이 3개 나머지는 1개
4. 모든 외벽의 개수의 합이 조명 설치 길이

채점 결과 : 244ms/28816KB
풀이 날짜 : 2022/01/29
*/

private val br by lazy { BufferedReader(InputStreamReader(System.`in`)) }
private val bw by lazy { BufferedWriter(OutputStreamWriter(System.out)) }

private val even = arrayOf(-1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to 0, 1 to 1)
private val odd = arrayOf(-1 to 0, -1 to -1, 0 to -1, 0 to 1, 1 to 0, 1 to -1)

fun main() {
    val (w, h) = br.readLine().split(" ").map { it.toInt() }
    val wall = Array(h) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visit = Array(h) { BooleanArray(w) }

    var answer = 0
    // 테두리 4변 탐색
    intArrayOf(0, h - 1).forEach { outerH ->
        repeat(w) {
            answer += when {
                wall[outerH][it] == 1 -> if ((outerH == 0 && it == w-1) || (outerH == h-1 && it == 0)) 1 else 2
                wall[outerH][it] == 0 && !visit[outerH][it] -> dfs(outerH, it, wall, visit, h, w)
                else -> 0
            }
        }
    }
    intArrayOf(0, w - 1).forEach { outerW ->
        repeat(h) {
            answer += when {
                wall[it][outerW] == 1 -> if ((outerW == 0 && it % 2 == 1) || (outerW == w - 1 && it % 2 == 0)) 3 else 1
                wall[it][outerW] == 0 && !visit[it][outerW] -> dfs(it, outerW, wall, visit, h, w)
                else -> 0
            }
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
    br.close()
}

// 0을 만나면 dfs 시작
private fun dfs(h: Int, w: Int, wall: Array<IntArray>, visit: Array<BooleanArray>, maxh: Int, maxw: Int): Int {
    visit[h][w] = true
    var count = 0
    repeat(6) {
        val (nh, nw) = if (h % 2 == 0) h + even[it].first to w + even[it].second else h + odd[it].first to w + odd[it].second
        if (nh in 0 .. wall.lastIndex && nw in 0..wall[0].lastIndex && !visit[nh][nw]) {
            count += if (wall[nh][nw] == 1) 1 else {
                visit[nh][nw] = true
                dfs(nh, nw, wall, visit, maxh, maxw)
            }
        }
    }
    return count
}