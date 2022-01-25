package boj.bronze

// Arm Coordination

fun main() {
    val (x, y) = readLine()!!.split(" ").map { it.toInt() }
    val r = readLine()!!.toInt()
    println("${x-r} ${y+r}"); println("${x+r} ${y+r}")
    println("${x+r} ${y-r}"); println("${x-r} ${y-r}")
}