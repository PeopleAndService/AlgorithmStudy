package boj.class1

fun main() {
    val str = readLine()!!.uppercase()
    val chars = mutableMapOf<Char, Int>()

    str.toSet().forEach { chars[it] = 0 }

    for (ch in str) {
        chars[ch] = chars[ch]!! + 1
    }

    val maxCnt = chars.maxOf { it.value }

    var answer = ""
    for ((key, value) in chars) {
        if (value == maxCnt) {
            if (answer.isNotEmpty()) {
                answer = "?"
                break
            } else {
                answer = key.toString()
            }
        }
    }

    println(answer)
}