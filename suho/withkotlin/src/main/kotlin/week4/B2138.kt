package week4

import kotlin.math.min

/*
플랫폼 : 백준
문제번호 : 2138
문제제목 : 전구와 스위치
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 그리디

알고리즘 설명
전구들의 상태가 있고, i번째 스위치는 i-1, i, i+1번째의 전구의 상태를 바꾸는데
i+1번째 전구의 상태는 중요하지 않음
그럼 2부터 n까지의 스위치 i들에 대해서 하나 이전의 전구 상태를 보고 스위치를 작동할 지 결정
    -> 1부터 n-1까지 스위치의 동작이 최적해임을 보장
그럼 0인덱스에선 어떻게? 0인덱스의 스위치는 i, i+1번째 전구만 바꿈
    -> 0 스위치를 눌렀을 때와 안눌렀을 때의 경우로 나눠서 수행
수행이 끝나면 마지막 전구의 상태를 비교해서 정답 출력

채점 결과 : 216ms/24468KB
풀이 날짜 : 2022/02/13
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = with(br.readLine()) { B2138(this.toInt()) }
    bw.write("${inst.greedy()}")
    bw.close()
}

class B2138(private val n: Int) {
    private val a = with(br.readLine()) {
        Array(2) { IntArray(n) { this[it] - '0' } }
    }
    private val b = with(br.readLine()) { IntArray(n) { this[it] - '0' } }
    private var firstOnAndDo = 1
    private var firstOffAndDo = 0

    init {
        br.close()
    }

    fun greedy(): Int {
        a[0][0] = a[0][0].xor(1)
        a[0][1] = a[0][1].xor(1)

        for (i in 1 until n) {
            if (a[0][i-1] != b[i-1]) {
                switch(i, 0)
                firstOnAndDo++
            }

            if (a[1][i-1] != b[i-1]) {
                switch(i, 1)
                firstOffAndDo++
            }
        }

        if (!check(0)) firstOnAndDo = Int.MAX_VALUE
        if (!check(1)) firstOffAndDo = Int.MAX_VALUE

        return if (firstOnAndDo == Int.MAX_VALUE && firstOffAndDo == Int.MAX_VALUE) -1 else min(firstOnAndDo, firstOffAndDo)
    }

    private fun switch(idx: Int, firstState: Int) {
        for (i in if (idx != n-1) idx-1..idx+1 else idx-1..idx) {
            a[firstState][i] = a[firstState][i].xor(1)
        }
    }

    private fun check(firstState: Int) = a[firstState].last() == b.last()
}