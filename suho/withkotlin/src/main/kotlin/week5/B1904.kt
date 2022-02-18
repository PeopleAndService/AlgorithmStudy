package week5

/*
플랫폼 : 백준
문제번호 : 1904
문제제목 : 01타일
난이도 : 실버 3
제한사항 : 0.75초/256MB
알고리즘 분류 : DP

알고리즘 설명
00타일과 1만 사용해서 수열을 만드는 것과 마찬가지
현재 자리에서 00타일을 붙이려면 길이 - 2를 봐야하고 1타일을 붙이려면 길이 - 1을 봐야함
결국 수열은 피보나치 수열 점화식과 동일해짐
n = 1이면 "1" 하나만 만들 수 있고 n = 2 이면 "00", "11" 2개 가능

채점 결과 : 108ms/12416KB
풀이 날짜 : 2022/02/18
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val MOD = 15746

fun main() {
    val n = br.readLine().toInt()
    bw.write("${tile(n, 1, 2)}")
    bw.close()
    br.close()
}

private tailrec fun tile(cur: Int, prev2: Int, prev1: Int): Int {
    if (cur == 1) return prev2
    if (cur == 2) return prev1
    return tile(cur - 1, prev1, (prev2 + prev1) % MOD)
}