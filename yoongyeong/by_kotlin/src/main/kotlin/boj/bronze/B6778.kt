package boj.bronze

// Which Alien?

fun main() {
    val (a, b) = List(2) { readLine()!!.toInt()}
    if (a>=3&&b<=4) println("TroyMartian")
    if (a<=6&&b>=2) println("VladSaturnian")
    if (a<=2&&b<=3) println("GraemeMercurian")
}