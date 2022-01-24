package boj.bronze

// Contest Timing

fun main() {
    var (d, h, m) = readLine()!!.split(" ").map { it.toInt() }
    if (m < 11) {h-- ; m+= 60}
    if (h < 11) {d-- ; h+= 24}
    ((d-11)*1440+(h-11)*60+m-11).run { print(if(this<0)-1 else this) }
}