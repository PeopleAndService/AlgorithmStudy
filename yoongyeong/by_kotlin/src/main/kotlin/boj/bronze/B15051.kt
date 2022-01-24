package boj.bronze

// Máquina de café

fun main() {
    val (a, b, c) = List(3) { readLine()!!.toInt()}
    print(minOf(b*2+4*c, minOf(2*(a+c), 4*a+2*b)))
}