package boj.bronze

// 鉛筆 (Pencils)

fun main() {
    val (a, b, c, d, e) = readLine()!!.split(" ").map { it.toInt() }
    val cnt1 = if(a%b==0) a/b*c
    else (a/b+1)*c
    val cnt2 = if(a%d==0) a/d*e
    else (a/d+1)*e
    print(minOf(cnt1, cnt2))
}