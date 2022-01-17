package boj.binary_search

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    var maxReq = 0
    val req = br.readLine().split(' ').map {
        val r = it.toInt()
        maxReq = maxOf(maxReq, r)
        r
    }
    val m = br.readLine().toInt()

    if (req.sum() <= m) {
        bw.write("$maxReq")
    } else {
        var start = 1
        var end = maxReq
        var mid = (start + end) / 2
        var answer = mid

        while (start <= end) {
            mid = (start + end) / 2
            var sum = 0

            for (r in req) {
                sum += if (r < mid) {
                    r
                } else {
                    mid
                }
            }

            if (sum <= m) {
                start += 1
                answer = mid
            } else {
                end -= 1
            }
        }

        bw.write("$answer")
    }

    bw.flush()
    bw.close()
}