package boj.bronze

// 3 つの整数 (Three Integers)

fun main() {
    val a = readLine()!!.split(" ").count{it.toInt() == 1}
    print(if (a in 2..3) 1 else 2)
}