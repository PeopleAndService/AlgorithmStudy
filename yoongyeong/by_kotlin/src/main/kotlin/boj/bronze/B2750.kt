package boj.bronze

// 수 정렬하기

fun main() {
    val numbers = ArrayList<Int>()
    repeat(readLine()!!.toInt()) {numbers.add(readLine()!!.toInt())}
    numbers.sort()
    for (i in numbers.indices) println(numbers[i])
}