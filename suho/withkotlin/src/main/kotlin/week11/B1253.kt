package week11

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1253
문제제목 : 좋다
난이도 : 골드 4
제한사항 : 2초/256MB
알고리즘 분류 : 자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵, 투 포인터

알고리즘 설명
1. 수들을 입력받으면서 map에 수의 개수를 센다. -> 위치가 다르면 다른 수이기 때문에
2. 두 수를 더할 때 0이 포함되는 경우 map의 value가 1이면 안된다. -> 하나만 0이면 2이상, 둘다 0이면 3이상
3. 결과에 map의 value를 더해주고 map에서 해당 수를 빼준다. -> 중복 제거

채점 결과 : 296ms/49228KB
풀이 날짜 : 2022/04/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val map = mutableMapOf<Int, Int>()
    val a = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt().also { map[it] = (map[it] ?: 0) + 1 } } }

    var answer = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val sum = a[i] + a[j]

            if (map.contains(sum)) {
                when {
                    a[i] == 0 && a[j] == 0 -> {
                        if ((map[sum] ?: 0) >= 3) {
                            answer += map[sum] ?: 0
                            map.remove(sum)
                        }
                    }
                    a[i] == 0 || a[j] == 0 -> {
                        if ((map[sum] ?: 0) >= 2) {
                            answer += map[sum] ?: 0
                            map.remove(sum)
                        }
                    }
                    else -> {
                        answer += map[sum] ?: 0
                        map.remove(sum)
                    }
                }
            }
        }
    }

    bw.write("$answer")
    bw.close()
    br.close()
}