package boj.class1

fun main() {
    repeat(readLine()!!.toInt()) {
        val (h, w, n) = readLine()!!.split(' ').map { it.toInt() }
        var f = n % h
        var r = n / h + 1

        if (h > n) {
            r = 1
        }

        if (n % h == 0) {
            f = h
            r = n / h
        }

        println(if (r < 10) "$f${0}$r" else "$f$r")
    }
}