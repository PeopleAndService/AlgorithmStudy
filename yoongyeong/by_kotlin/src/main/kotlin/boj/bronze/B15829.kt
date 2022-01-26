package boj.bronze

// Hashing

fun main() {
    val length = readLine()!!.toInt()
    val l = readLine()!!; var answer = 0L; var r = 1L
    for (index in 0 until length) {
        answer = (answer + (l[index] - 'a' + 1) * r) % 1234567891
        r = (r * 31) % 1234567891
    }
    print(answer)
}