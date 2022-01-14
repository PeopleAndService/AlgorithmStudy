package boj.silver

// 그룹 단어 체커

fun main() {
    val n = readLine()!!.toInt()
    var answer = n
    repeat(n) {
        val word = readLine()!!
        for (i in word.indices) {
            if (i != 0 && word[i] != word[i-1] && word[i] in word.slice(0 until i)) {answer -= 1; break}
        }
    }
    println(answer)
}