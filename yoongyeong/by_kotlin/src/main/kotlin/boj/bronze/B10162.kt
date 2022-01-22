package boj.bronze

// 전자레인지

fun main() {
    val t = readLine()!!.toInt()
    val (a, b, c) = Triple(t/300, t%300/60, t%300%60/10)
    println(if(t%10==0)"$a $b $c" else "-1")
}