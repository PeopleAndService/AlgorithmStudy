package simulation_greedy

import java.util.*

// 주유소

fun main(){
    var result = 0L; var minimum = Long.MAX_VALUE; var dist = 0L

    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val distances = br.readLine().split(" ").map { it.toLong() }
    StringTokenizer(br.readLine()).run {
        repeat(n - 1) {
            nextToken().toLong().run {
                if (this < minimum) {
                    result += dist * minimum
                    dist = 0
                    minimum = this
                }
                dist += distances[it]
            }
        }
    }
    result += dist * minimum
    print(result)
}