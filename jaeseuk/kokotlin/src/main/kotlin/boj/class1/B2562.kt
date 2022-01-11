package boj.class1

fun main() {
    var idx = 0
    var value = 0
    repeat(9) {
        val num = readLine()!!.toInt()
        if (num > value) {
            idx = it
            value = num
        }
    }
    println(value)
    println(idx + 1)
}