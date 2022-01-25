package boj.bronze

// ICPC

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val (c, d) = readLine()!!.split(" ").map { it.toInt() }
    when {
        a+d>b+c -> print("Persepolis")
        a+d<b+c -> print("Esteghlal")
        else -> {
            when {
                a==c -> print("Penalty")
                a>c -> print("Esteghlal")
                else -> print("Persepolis")
            }
        }
    }
}