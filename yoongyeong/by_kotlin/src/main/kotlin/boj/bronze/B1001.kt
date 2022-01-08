package boj.bronze

// A-B

fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    println(a - b)
    solution()
}

private fun solution() = print(readLine()!!.let{it[0]-it[2]})