package week5

import kotlin.math.max

/*
플랫폼 : 백준
문제번호 : 1912
문제제목 : 연속합
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : DP

알고리즘 설명
1. 이전까지의 연속 부분수열 중 최대합 + 현재 숫자, 현재 숫자의 최대값을 메모이제이션
2. 각 과정에서 최대값(정답) 갱신

채점 결과 : 꼬리재귀-288ms/30196KB, DP-284ms/30204KB
풀이 날짜 : 2022/02/17
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    bw.write("${B1912(
        br.readLine().toInt(),
        br.readLine().split(" ").map { it.toInt() }
    ).answer}")
    bw.close()
    br.close()
}

class B1912(private val n: Int, private val num: List<Int>) {
    private var _answer = num[0]
    val answer: Int
        get() = _answer

    init {
        dp(1, _answer)
    }

    private tailrec fun dp(cur: Int, value: Int) {
        _answer = max(_answer, value)
        if (cur >= n) return
        dp(cur + 1, max(value + num[cur], num[cur]))
    }
}

/*
fun main() {
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }

    var dp = nums[0]
    var answer = nums[0]
    for (i in 1 until n) {
        dp = max(dp + nums[i], nums[i])
        answer = max(answer, dp)
    }

    bw.write("$answer")
    bw.close()
    br.close()
}*/
