package week7

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 10800
문제제목 : 컬러볼
난이도 : 골드 3
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 정렬, 누적 합

알고리즘 설명
1. 볼들을 배열에 담고 크기 순으로 정렬
2. 각 볼들에 대해서 자신보다 크기가 작은 볼들의 크기의 합을 계산
3. 계산하면서 각 색깔별로 누적합 계산
prevIdx는 반복문 밖에서 선언되어있기 때문에 중복 계산되지 않음
4. 크기의 합에서 같은 색상의 크기를 빼줌

채점 결과 : 1420ms/183660KB
풀이 날짜 : 2022/03/07
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val balls = Array(n) { with(StringTokenizer(br.readLine())) {
        Ball(it, nextToken().toInt(), nextToken().toInt())
    } }.sortedArrayWith(compareBy { it.size })

    val answer = IntArray(n)
    val colorSum = IntArray(n+1)
    var prevIdx = 0
    var sizeSum = 0
    for (i in 0..balls.lastIndex) {
        val (idx, color, size) = balls[i]
        while (true) {
            val prev = balls[prevIdx]

            if (prev.size >= size) break

            sizeSum += prev.size
            colorSum[prev.color] += prev.size
            prevIdx++
        }
        answer[idx] = sizeSum - colorSum[color]
    }
    bw.write(answer.joinToString("\n"))
    bw.close()
    br.close()
}

data class Ball(
    val idx: Int,
    val color: Int,
    val size: Int
)