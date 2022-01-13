package boj.class1

fun main() {
    val l = readLine()!!.toInt()
    val r = 31.toBigInteger()
    val m = 1234567891.toBigInteger()

    println(readLine()!!.foldIndexed(0.toBigInteger()) { idx, acc, ch ->
        acc + (ch - 'a' + 1).toBigInteger() * r.pow(idx)
    } % m)
}