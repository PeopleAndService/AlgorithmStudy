package boj.bronze

// Koszykarz

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    print(if((b-a)%c!=0)(b-a)/c+1 else (b-a)/c)
}