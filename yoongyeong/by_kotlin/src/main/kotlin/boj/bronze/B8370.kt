package boj.bronze

// Plane

fun main() {
    val (n1, k1, n2, k2) = readLine()!!.split(" ").map { it.toInt() }
    println(n1*k1+n2*k2)
}