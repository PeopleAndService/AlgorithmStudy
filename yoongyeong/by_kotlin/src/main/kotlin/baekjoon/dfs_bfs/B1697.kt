package baekjoon.dfs_bfs

import java.util.*

// 숨바꼭질

fun main() {
    print(bfs())
}

private fun bfs(): Int {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val visited = BooleanArray(100_001)
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(n, 0)); visited[n] = true

    while (queue.isNotEmpty()) {
        val (newPoint, time) = queue.poll()
        if (newPoint == k) return time

        if (checkRange(newPoint+1) && !visited[newPoint+1]) {
            queue.add(Pair(newPoint+1, time+1)); visited[newPoint+1] = true
        }
        if (checkRange(newPoint-1) && !visited[newPoint-1]) {
            queue.add(Pair(newPoint-1, time+1)); visited[newPoint-1] = true
        }
        if (checkRange(newPoint*2) && !visited[newPoint*2]) {
            queue.add(Pair(newPoint*2, time+1)); visited[newPoint*2] = true
        }
    }

    return -1
}

private fun checkRange(x: Int) = x in 0 .. 100_000