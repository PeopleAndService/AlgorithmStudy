package simulation_greedy

import java.util.*

// 멀티탭 스케줄링

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val plugs = StringTokenizer(br.readLine()).run { IntArray(k) {nextToken().toInt()} }
    val used = BooleanArray(k+1)
    var result = 0

    for ((index, plug) in plugs.withIndex()) {
        if (used[plug]) continue // 이미 꽂혀있음
        if (used.count{it} < n) used[plug] = true // 비어 있는 곳이 있다면 넣어준다.
        else {
            val list = mutableListOf<Int>()
            for (next in index + 1 until k) {
                if (used[plugs[next]] && plugs[next] !in list) list.add(plugs[next])
            }

            if (list.size != n) {
                // 나중에 사용되지 않을 콘센트를 제거해준다.
                for ((nextPlug, use) in used.withIndex()) {
                    if (use && nextPlug !in list) {used[nextPlug] = false; break}
                }
            } else used[list.last()] = false // 가장 마지막에 사용될 콘센트 제거

            used[plug] = true
            result += 1
        }
    }

    print(result)
}