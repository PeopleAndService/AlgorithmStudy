package week9

/*
플랫폼 : 백준
문제번호 : 10775
문제제목 : 공항
난이도 : 골드 2
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 그리디 알고리즘, 분리 집합

알고리즘 설명
1. i번째 비행기는 1번부터 Gi 게이트까지 가능하기 때문에 Gi 게이트부터 채운다.
2. 게이트를 채웠으면 Gi와 Gi-1 게이트를 union, 다음 Gi 게이트가 최대인 비행기가 들어오면 Gi-1 게이트에 들어가도록 한다.
3. 들어오는 비행기에 차례대로 Gi 게이트의 현재 부모(다음 비어있는 게이트를 가리킴)를 확인해서 0이 나오면 종료

채점 결과 : 240ms/21940KB
풀이 날짜 : 2022/03/21
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var parents: IntArray

fun main() {
    val g = br.readLine().toInt()
    val p = br.readLine().toInt()
    parents = IntArray(g + 1) { it }

    var count = 0
    run {
        repeat(p) {
            val maxGate = br.readLine().toInt()
            val realGate = find(maxGate)

            if (realGate == 0) return@run

            count++
            union(realGate, realGate - 1)
        }
    }

    bw.write("$count")
    bw.close()
    br.close()
}

private fun find(x: Int): Int {
    return if (x == parents[x]) x
    else {
        parents[x] = find(parents[x])
        parents[x]
    }
}

private fun union(a: Int, b: Int) {
    val aP = find(a)
    val bP = find(b)

    if (aP != bP) {
        parents[aP] = bP
    }
}