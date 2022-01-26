package boj.bronze

// Rulltrappa

fun main() {
    val (m, s, g) = readLine()!!.split(" ").map { it.toDouble() }
    val (a, b) = readLine()!!.split(" ").map { it.toDouble() }
    val (l, r) = readLine()!!.split(" ").map { it.toDouble() }
    print(if (m/s+r/b<m/g+l/a) "latmask" else "friskus")
}