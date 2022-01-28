package boj.silver

import java.io.BufferedReader
import java.io.InputStreamReader

// 수 정렬하기 2

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    print(List(this.readLine().toInt()) {this.readLine().toInt()}.sorted().joinToString("\n"))
}

// 시간 복잡도를 줄일 수 있는 방법
private fun solution() =  with(BufferedReader(InputStreamReader(System.`in`))) {
    val array = BooleanArray(2000001)

    for (i in 0 until this.readLine().toInt()) array[this.readLine().toInt()+1000000] = true

    val sb = StringBuilder()
    for (i in array.indices) {
        if (array[i]) sb.append((i - 1000000).toString() + "\n")
    }
    println(sb.toString())
}
