package boj.bronze

// Archivist

fun main() {
    print(when (readLine()!!.toInt()) {
        1996, 1997, 2000, 2007, 2008, 2013, 2018 -> "SPbSU"
        2006 -> "PetrSU, ITMO"
        else -> "ITMO"
    })
}