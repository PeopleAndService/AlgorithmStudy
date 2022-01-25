package boj.bronze

// Äpplen och päron

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    print(if(a*7==b*13) "lika" else if (a*7>b*13) "Axel" else "Petra")
}