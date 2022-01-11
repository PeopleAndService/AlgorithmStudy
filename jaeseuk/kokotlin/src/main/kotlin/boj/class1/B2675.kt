package boj.class1

fun main() {
    repeat(readLine()!!.toInt()) {
        val (r, s) = readLine()!!.split(' ')
        var answer = ""
        s.forEach { answer += it.toString().repeat(r.toInt()) }
        println(answer)
    }
}