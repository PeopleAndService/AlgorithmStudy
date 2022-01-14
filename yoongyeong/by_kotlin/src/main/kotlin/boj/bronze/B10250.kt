package boj.bronze

// ACM 호텔

fun main() {
    repeat(readLine()!!.toInt()) {
        val (h, _, n) = readLine()!!.split(' ').map { it.toInt() }
        var floor = n % h
        var room = n / h + 1

        if (h > n) room = 1

        if (n % h == 0) {
            floor = h
            room = n / h
        }

        println(if(room < 10) "$floor${0}$room" else "$floor$room")
    }
}