package boj.bronze

// 직사각형에서 탈출

fun main() {
    val (x, y, w, h) = readLine()!!.split(" ").map { it.toInt() }
    print(listOf((h-y), (w-x), x, y).minOf { it })
}