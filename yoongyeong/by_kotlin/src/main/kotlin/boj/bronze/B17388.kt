package boj.bronze

// 와글와글 숭고한

fun main() {
    val campus = readLine()!!.split(" ").map { it.toInt() }
    if (campus.sum() < 100) {
        when(campus.minOf { it }){
            campus[0] -> print("Soongsil")
            campus[1] -> print("Korea")
            campus[2] -> print("Hanyang")
        }
    } else print("OK")
}