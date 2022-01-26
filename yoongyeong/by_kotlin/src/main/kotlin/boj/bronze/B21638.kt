package boj.bronze

// SMS from MCHS

fun main() {
    val (t1, v1) = readLine()!!.split(" ").map { it.toInt() }
    val (t2, v2) = readLine()!!.split(" ").map { it.toInt() }
    print(when{
        t2 < 0 && v2 >= 10 -> "A storm warning for tomorrow! Be careful and stay home if possible!"
        t1 > t2 -> "MCHS warns! Low temperature is expected tomorrow."
        v1 < v2 -> "MCHS warns! Strong wind is expected tomorrow."
        else -> "No message"
    })
}