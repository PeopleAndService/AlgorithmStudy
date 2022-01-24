package boj.bronze

// Identifying tea

fun main() {
    val n = readLine()!!.toInt()
    print(readLine()!!.split(" ").count { it.toInt() == n })
}