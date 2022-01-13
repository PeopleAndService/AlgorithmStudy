package boj.bronze

// 평균은 넘겠지

fun main() {
    val test = readLine()!!.toInt()
    repeat(test) {
        val students = readLine()!!.split(" ").map { it.toDouble() }
        val avg = (students.sum() - students[0]) / students[0]
        println("${String.format("%.3f", students.slice(1 until students.size).filter { it > avg }.size/students[0]*100)}%")
    }
}