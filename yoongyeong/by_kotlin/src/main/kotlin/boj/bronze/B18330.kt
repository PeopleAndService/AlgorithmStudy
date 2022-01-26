package boj.bronze

// Petrol

fun main() {
    var (a, b) = List(2){ readLine()!!.toInt() }
    b += 60
    print(if (a >= b) b*1500+(a-b)*3000
    else a*1500)
}