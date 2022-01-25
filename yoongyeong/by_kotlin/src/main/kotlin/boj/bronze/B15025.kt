package boj.bronze

// Judging Moose

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    if (a==0&&b==0) print("Not a moose")
    else if (a==b) print("Even ${2*a}")
    else print("Odd ${2* maxOf(a, b)}")
}