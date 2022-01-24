package boj.bronze

// Patyki

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    if (a==b&&b==c) print(2)
    else if(a*a+b*b==c*c||b*b+c*c==a*a||a*a+c*c==b*b) print(1)
    else print(0)
}