package boj.bronze

// 전자레인지

fun main() {
    val (a, b, c, d, e) = List(5) { readLine()!!.toInt()}
    println(when {
        a > 0 -> "${e * (b - a)}"
        a == 0 -> "${d+b * e}"
        else -> "${(-a) * c + d + b * e}"
    })
}