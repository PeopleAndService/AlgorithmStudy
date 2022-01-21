package boj.bronze

// 주사위 세개

fun main() {
    val dices = IntArray(6)
    var maxi = 0
    readLine()!!.split(" ").map { dices[it.toInt()-1] += 1 }
    for (i in 5 downTo 0) {
        when (dices[i]) {
            3 -> {println(10000 + (i+1) * 1000); return}
            2 -> {println(1000 + (i+1) * 100); return}
            1 -> {if (maxi < i + 1) maxi = i + 1}
        }
    }
    println(maxi * 100)
}