package binarysearch_parametricsearch

import java.util.*

// 집배원 한상덕

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private val board = Array(n) { CharArray(n) }; private val height = Array(n) { IntArray(n) }
private var heightSet = mutableSetOf<Int>()
private var result = Int.MAX_VALUE

private lateinit var postOffice: Pair<Int, Int>
private var houseCnt = 0

private val stepX = listOf(-1,  0,  1, -1, 0, 1, -1, 1)
private val stepY = listOf(-1, -1, -1,  1, 1, 1,  0, 0)

fun main() {
    for (row in 0 until n) {
        with(StringTokenizer(br.readLine())) {
            for ((col, char) in nextToken().withIndex()) {
                board[row][col] = char
                if (char == 'P') postOffice = Pair(row, col)
                if (char == 'K') houseCnt ++
            }
        }
    }
    for (row in 0 until n) {
        with(StringTokenizer(br.readLine())) {
            for (col in 0 until n) {
                height[row][col] = nextToken().toInt()
                heightSet.add(height[row][col])
            }
        }
    }
    heightSet = heightSet.toSortedSet()

    for (i in heightSet.indices) {
        var low = i; var high = heightSet.size - 1
        while (low <= high) {
            val mid = (low + high) / 2
            if (deliveryPost(heightSet.elementAt(i), heightSet.elementAt(mid))) {
                high = mid - 1; result = minOf(result, heightSet.elementAt(mid) - heightSet.elementAt(i))
            }
            else low = mid + 1
        }
    }

    print(result)
}

private fun deliveryPost(minimum: Int, maximum: Int): Boolean {
    // 우체국의 높이가 범위를 벗어날 경우 불가능한 경우
    if (height[postOffice.first][postOffice.second] !in minimum .. maximum) return false
    val visited = Array(n) {BooleanArray(n)}
    var visitHouse = houseCnt
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(postOffice); visited[postOffice.first][postOffice.second] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 8) {
            val nx = x + stepX[i]; val ny = y + stepY[i]
            // 보드의 범위를 벗어날 때
            if (nx !in 0 until n || ny !in 0 until n) continue
            // 방문한적이 있을 때
            if (visited[nx][ny]) continue
            // 해당 좌표의 높이가 범위를 벗어날 때
            if (height[nx][ny] !in minimum .. maximum) continue
            if (board[nx][ny] == 'K') visitHouse -= 1
            visited[nx][ny] = true
            queue.add(Pair(nx, ny))
        }
    }

    return visitHouse == 0
}