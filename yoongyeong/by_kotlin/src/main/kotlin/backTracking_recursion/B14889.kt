package backTracking_recursion

import java.io.BufferedReader
import java.io.InputStreamReader

// 스타트와 링크

private var n = 0
private var result = Int.MAX_VALUE
private lateinit var company: List<List<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    company = List(n) {br.readLine().split(" ").map { it.toInt() }}

    makeTeam()
    print(result)
}

private fun makeTeam(depth: Int = 1, idx: Int = 1, peoples: IntArray = IntArray(n / 2)) {
    if (depth == n / 2) { calculatorPower(peoples); return }

    for (index in idx until n) {
        peoples[depth] = index
        makeTeam(depth + 1, index + 1, peoples )
    }
}

private fun calculatorPower(peoples: IntArray) {
    var teamA = 0; var teamB = 0
    val isTeamA = BooleanArray(n)

    for (people in peoples) isTeamA[people] = true

    for (people1 in 0 until n) {
        for (people2 in people1 + 1 until n) {
            if (isTeamA[people1] == isTeamA[people2]) {
                if (isTeamA[people1]) teamA += company[people1][people2] + company[people2][people1]
                else teamB += company[people1][people2] + company[people2][people1]
            }
        }
    }
    result = minOf(result, kotlin.math.abs(teamA-teamB))
}