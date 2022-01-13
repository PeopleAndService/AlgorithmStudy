package boj.bronze

// 더하기 사이클

fun main() {
    val n = readLine()!!.toInt()
    var cycle = 1
    var new_n = n%10*10+(n%10+n/10)%10
    while (n != new_n) {
        new_n = new_n%10*10+(new_n%10+new_n/10)%10
        cycle += 1
    }
    println(cycle)
}