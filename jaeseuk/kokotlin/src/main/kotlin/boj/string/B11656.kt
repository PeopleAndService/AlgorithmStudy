package boj.string

fun main() {
    val s = readLine()!!
    val dict = List(s.length) { s.drop(it) }.sorted()
    dict.forEach { println(it) }
}