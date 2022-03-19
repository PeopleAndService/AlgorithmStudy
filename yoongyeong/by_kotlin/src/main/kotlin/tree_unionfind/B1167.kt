package tree_unionfind

// 트리의 지름

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private val graph = Array(n+1) { mutableListOf<Int>() }
private var distances = Array(n+1) { mutableListOf<Int>() }
private val visited = BooleanArray(n+1)
private var answer = Int.MIN_VALUE
private var point = 0

fun main() {
    for (i in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        val a = line[0]
        for (j in 1 until line.size) {
            if (line[j] == -1) break
            if (j % 2 == 1) graph[a].add(line[j])
            else distances[a].add(line[j])
        }
    }
    bfs(1, 0)
    visited.fill(false)

    bfs(point, 0)
    println(answer)

}

private fun bfs(v: Int, d: Int) {
    var index = 0
    visited[v] = true
    for (i in graph[v]) {
        if (!visited[i]) {
            val distance = d + distances[v][index]
            if (answer < distance) {
                point = i
                answer = distance
            }
            bfs(i, distance)
        }
        index ++
    }
}