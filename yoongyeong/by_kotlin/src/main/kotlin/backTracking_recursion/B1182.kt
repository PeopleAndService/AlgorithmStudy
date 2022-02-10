package backTracking_recursion

// 부분수열의 합

private var n = 0
private var s = 0
private lateinit var array: Array<Int>

private var cnt = 0

fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine().split(" ").run {
        n = this.first().toInt(); s = this.last().toInt()
    }
    array = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    sumOfPart()

    print(if(s==0) cnt-1 else cnt)
}

private fun sumOfPart(index: Int = 0, depth: Int = 0, sum: Int = 0) {
    if (sum == s) cnt++
    if (depth == n) return

    for (i in index until n) {
        sumOfPart(i + 1, depth + 1, sum + array[i])
    }
}