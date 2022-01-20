package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*
플랫폼 : 백준
문제번호 : 18115
문제제목 : 카드 놓기
난이도 : 실버 3
제한사항 : 2초/1024MB
알고리즘 분류 : 자료구조, 덱

알고리즘 설명
덱 자료구조 사용
1. 카드를 꺼낸 방법의 순서를 뒤집는다. -> 카드 순서를 다시 만들어야 하기 때문(꺼낸 역순으로 넣어야되기 때문)
2. 역순으로 바뀐 방법과 숫자 1부터 따라가면서
3. 1방법은 덱의 앞에 삽입
4. 2방법은 덱의 앞을 꺼내고 숫자를 먼저 넣고 꺼낸 앞을 넣는다.
5. 3방법은 덱의 뒤에 삽입
6. 덱을 앞에서부터 출력

채점 결과 : 996ms/301168KB
풀이 날짜 : 2022/01/20
*/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = stoi(br.readLine())
    val input = br.readLine().split(" ")
    val orders = IntArray(n) { stoi(input[it]) }
    orders.reverse() // 배열 뒤집기

    val list = LinkedList<Int>()
    solution(orders, list, n)

    while (!list.isEmpty()) {
        bw.write("${list.pollFirst()} ")
    }

    bw.flush()
    bw.close()
    br.close()
}

fun solution(orders: IntArray, deque: Deque<Int>, n: Int) {
    for (i in 1..n) {
        when (orders[i-1]) {
            1 -> {
                deque.offerFirst(i)
            }
            2 -> {
                val temp = deque.pollFirst()
                deque.offerFirst(i)
                deque.offerFirst(temp)
            }
            else -> {
                deque.offerLast(i)
            }
        }
    }
}