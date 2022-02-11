package week3

/*
플랫폼 : 백준
문제번호 : 14225
문제제목 : 부분수열의 합
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
1. sum을 상태로 갖는 백트래킹 수행
2. Boolean 배열에 sum을 마킹
3. false가 나오는 첫번째 인덱스를 indexOfFirst 함수로 찾음

채점 결과 : 160ms/22728KB
풀이 날짜 : 2022/02/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private lateinit var nums: List<Int>
private val flag = BooleanArray(2000001)

fun main() {
    n = br.readLine().toInt()
    nums = br.readLine().split(" ").map { it.toInt() }
    br.close()

    dfs(0, 0, 0)

    bw.write("${flag.indexOfFirst { !it }}")
    bw.close()
}

private fun dfs(depth: Int, index: Int, sum: Int) {
    flag[sum] = true
    if (depth == n) return

    for (i in index until n) {
        dfs(depth + 1, i + 1, sum + nums[i])
    }
}