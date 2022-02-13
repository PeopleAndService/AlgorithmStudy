package week4

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1080
문제제목 : 행렬
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 그리디 알고리즘

알고리즘 설명
1. a 행렬을 b가 되도록 만들어야 하는데, a 행렬은 한번에 3x3 사이즈만 1 -> 0, 0 -> 1로 변환이 가능
2. 각 꼭지점마다 3x3씩 확인해서 바꾸고 바꾸고 하는 과정은 시간초과가 뻔함
3. (0, 0) 부터 (n-3, m-3) 까지 각 점이 다르면 변환 수행
4. 마지막에 같은지 체크하면 된다.

채점 결과 : 108ms/16440KB
풀이 날짜 : 2022/02/12
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = with(StringTokenizer(br.readLine())) {
        B1080(nextToken().toInt(), nextToken().toInt())
    }

    bw.write("${inst.greedy()}")
    bw.close()
    br.close()
}

class B1080(private val n: Int, private val m: Int) {
    private val a: Array<IntArray> = Array(n) { with(br.readLine()) { IntArray(m) { this[it] - '0' } } }
    private val b: Array<IntArray> = Array(n) { with(br.readLine()) { IntArray(m) { this[it] - '0' } } }

    fun greedy(): Int {
        if (n < 3 || m < 3) return if (checkSame()) 0 else -1

        var count = 0

        for (r in 0..n-3) {
            for (c in 0..m-3) {
                if (a[r][c] != b[r][c]) {
                    reverseA(r, c)
                    count++
                }
            }
        }

        return if (checkSame()) count else -1
    }

    private fun reverseA(r: Int, c: Int) {
        for (nr in r until r+3) {
            for (nc in c until c+3) {
                a[nr][nc] = a[nr][nc].xor(1)
            }
        }
    }

    private fun checkSame() = a.contentDeepEquals(b)
}