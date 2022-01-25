package boj.bronze

// Bicycle

fun main() {
    val (a, x, b, y, t) = List(5) { readLine()!!.toInt()}
    val fee1 = if(t > 30) a + (t-30)*x*21 else a
    val fee2 = if(t > 45) b + (t-45)*y*21 else b
    print("$fee1 $fee2")
}