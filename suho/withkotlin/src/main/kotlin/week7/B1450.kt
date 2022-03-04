package week7

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1450
문제제목 : 냅색문제
난이도 : 골드 1
제한사항 : 1초/128MB
알고리즘 분류 : 이분 탐색, meet in the middle

알고리즘 설명
문제 주석

채점 결과 : 324ms/28896KB
풀이 날짜 : 2022/03/04
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val c: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        c = nextToken().toInt()
    }
    val things = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } }

    /*
     1. meet in the middle 알고리즘 사용
     완전 탐색 하기에 경우가 너무 큰 경우 사용하는 알고리즘, 분할 정복을 베이스로 하고 있으며
     전체를 반으로 나눠서 작업을 수행하는 알고리즘이다.
     */
    val leftHalf = things.sliceArray(0 until (n / 2))
    val rightHalf = things.sliceArray((n / 2) until n)

    /*
     2. 반으로 나눈 배열의 부분 집합을 구하고 그 부분 집합(0 포함)의 합을 찾는다.
     합 = 가방에 넣을 수 있는 무게의 조합
     */
    val sumOfLeftSubSet = mutableListOf<Long>().apply {
        makeSubSetAndCalcSum(leftHalf, this, 0L, 0, leftHalf.size)
        sort()
    }
    val sumOfRightSubSet = mutableListOf<Long>().apply {
        makeSubSetAndCalcSum(rightHalf, this, 0L, 0, rightHalf.size)
    }

    // 3. 각 합이 담긴 리스트 정렬 -> MutableList 라서 sorted 대신 sort 사용
    sumOfLeftSubSet.sort()
    sumOfRightSubSet.sort() // 얘는 굳이 정렬 안해도 된다.

    /*
     4. 한 쪽 리스트의 값들로 다른 쪽 리스트에서 (c - 합)의 upper bound를 구해서 그 합을 계산한다.
     3가지 방법 사용 -> 컬렉션 연산의 수행 시간 비교하기 좋은 예제라서 (그래도 forEach가 제일 빠름)
     */
    var answer = 0L
    sumOfRightSubSet.forEach { rSum ->
        // println("forEach: $rSum")
        if (rSum <= c) {
            answer += upperBound(sumOfLeftSubSet, c - rSum)
        }
    }

    // 중간 연산을 지연 수행하는 시퀀스 (map 연산의 호출 횟수를 비교하면 된다.)
    /*val answer = sumOfRightSubSet.asSequence().map { rSum ->
        // println("map: $rSum")
        c - rSum
    }.takeWhile { mapped ->
        mapped >= 0
    }.sumOf {
        upperBound(sumOfLeftSubSet, it).toLong()
    }*/

    // 중간 연산을 차례로 수행
    /*val answer = sumOfRightSubSet.map { rSum ->
        // println("map: $rSum")
        c - rSum
    }.takeWhile { mapped ->
        mapped >= 0
    }.sumOf { it
        upperBound(sumOfLeftSubSet, it).toLong()
    }*/

    bw.write("$answer")
    bw.close()
    br.close()
}

private fun makeSubSetAndCalcSum(arr: IntArray, saveIn: MutableList<Long>, sum: Long, idx: Int, limit: Int) {
    if (idx == limit) {
        saveIn.add(sum)
        return
    }

    makeSubSetAndCalcSum(arr, saveIn, sum + arr[idx], idx + 1, limit)
    makeSubSetAndCalcSum(arr, saveIn, sum, idx + 1, limit)
}

private fun upperBound(list: List<Long>, value: Long): Int {
    var start = 0
    var end = list.size

    while (start < end) {
        val mid = (start + end) / 2

        if (list[mid] <= value) {
            start = mid + 1
        } else {
            end = mid
        }
    }

    return end
}