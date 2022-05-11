package baekjoon.topologicalsort_floydwashal

import java.util.StringTokenizer

// 키 순서

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); m = nextToken().toInt()
    }
    val students = Array(n+1) { BooleanArray(n+1) }
    val studentsR = Array(n+1) { BooleanArray(n+1) }

    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            students[a][b] = true
            studentsR[b][a] = true
        }
    }

    for (k in 1 .. n) {
        for (i in 1 .. n) {
            for (j in 1 .. n) {
                if (students[i][k] && students[k][j]) students[i][j] = true
                if (studentsR[i][k] && studentsR[k][j]) studentsR[i][j] = true
            }
        }
    }

    for (i in 1 .. n) {
        for (j in 1 .. n) {
            students[i][j] = students[i][j] || studentsR[i][j]
        }
    }

    var answer = 0

    scope@for (i in 1 .. n) {
        for (j in 1 .. n) {
            if (i == j) continue
            if (!students[i][j]) continue@scope
        }
        answer ++
    }

    print(answer)
}