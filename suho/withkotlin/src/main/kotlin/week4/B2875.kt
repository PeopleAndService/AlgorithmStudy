package week4

/*
플랫폼 : 백준
문제번호 : 2875
문제제목 : 대회 or 인턴
난이도 : 브론즈 3
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 구현

알고리즘 설명
1. 여자가 2명이상, 남자가 1명이상 이고 전체 학생 수가 인턴십 참가 학생 수 k보다 팀 하나를 구성할 만큼 많으면
2. 팀 수 + 1, 여자 - 2, 남자 - 1

채점 결과 : 128ms/20668KB
풀이 날짜 : 2022/02/11
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var n: Int
    var m: Int
    var k: Int
    br.readLine().split(" ").map { it.toInt() }.also { (a, b, c) ->
        n = a
        m = b
        k = c
    }
    br.close()
    
    var answer = 0
    while (n >= 2 && m >= 1 && n + m >= k + 3) {
        answer++
        n -= 2
        m -= 1
    }
    
    bw.write("$answer")
    bw.close()
}