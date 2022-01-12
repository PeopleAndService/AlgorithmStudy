package boj.bronze

// 달달함이 넘쳐흘러

fun main() {
    val (ax, ay, az) = readLine()!!.split(" ").map { it.toInt() }
    val (cx, cy, cz) = readLine()!!.split(" ").map { it.toInt() }
    println("${cx-az} ${cy/ay} ${cz-ax}")
}