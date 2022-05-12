package baekjoon.binarysearch_parametricsearch

// K번째 수

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    val k = br.readLine().toLong()
    var low = 1L; var high = k
    var result = 0L

    while(low <= high) {
        val mid = (low + high) / 2
        if(getCountNum(mid, n) >= k) { result = mid; high = mid - 1 }
        else low = mid + 1
    }

    print(result)
}

private fun getCountNum(mid: Long, n: Long): Long {
    var cnt = 0L
    for (i in 1 .. n) cnt += minOf(n, mid / i)
    return cnt
}