package boj.bronze

// Laptop Sticker

fun main() {
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toInt() }
    print(if(a-c>=2 && b-d>=2) 1 else 0)
}