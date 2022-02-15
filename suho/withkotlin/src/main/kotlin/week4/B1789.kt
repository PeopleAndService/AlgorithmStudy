package week4

/*
플랫폼 : 백준
문제번호 : 1789
문제제목 : 수들의 합
난이도 : 실버 5
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 그리디 알고리즘

알고리즘 설명
그리디 알고리즘에 의해, 1부터 쭈욱 더해나가다가 합이 n보다 크면 종료하고 더한 수의 개수에서 1을 뺀다.

채점 결과 : 92ms/12284KB
풀이 날짜 : 2022/02/15
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toLong()
    var count = 1
    var sum = 0L
    while (true) {
        sum += count
        if (sum > n) {
            count--
            break
        }
        count++
    }
    bw.write("$count")
    bw.close()
    br.close()
}