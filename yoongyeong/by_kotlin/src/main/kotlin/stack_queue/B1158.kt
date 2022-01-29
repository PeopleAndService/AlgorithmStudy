package stack_queue

import java.lang.StringBuilder

// 요세푸스 문제

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val peoples = MutableList(n) {x -> x+1}
    var idx = k - 2
    val sb = StringBuilder("<$k")
    peoples.removeAt(k-1)

    while (peoples.size > 0) {
        idx = (idx + k) % peoples.size
        sb.append(", ${peoples[idx]}")
        peoples.removeAt(idx--)
    }
    println("$sb>")
}