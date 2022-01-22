package boj.bronze

// 10부제

fun main() {
    val day = readLine()!!.toInt()
    val cars = readLine()!!.split(" ").map { it.toInt() }
    println(cars.count{it == day})
}