package week9

import java.util.*

/*
플랫폼 : 백준
문제번호 : 17472
문제제목 : 다리 만들기 2
난이도 : 골드 1
제한사항 : 1초/512MB
알고리즘 분류 : 구현, 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, BFS, DFS, 최소 스패닝 트리

알고리즘 설명
1. 입력받은 지도에서 섬을 만들어야 한다. bfs로 연결되어 있는 덩어리에 같은 숫자 부여 -> findIsland, bfs
2. 지도에서 정점이 선이라면 4방향으로 다리를 만들어서 다른 섬을 만나면 그래프 연결(간선 정보를 우선순위 큐에 담는다.)
-> 다리의 길이는 2이상, 직선 방향으로만 연결되어야 한다. makeGraph, checkBridge
3. 그래프를 만들었다면 간선이 담긴 우선순위 큐로 크루스칼 알고리즘 수행 -> kruskal
4. 모든 섬들이 같은 부모를 가진다면 최소 신장 트리가 만들어진 경우, 아닌 경우 -1

채점 결과 : 140ms/18836KB
풀이 날짜 : 2022/03/23
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = with(StringTokenizer(br.readLine())) {
        B17472(nextToken().toInt(), nextToken().toInt())
    }

    inst.input()
    inst.findIsland()
    inst.makeGraph()
    val answer = inst.kruskal()

    bw.write("$answer")
    bw.close()
    br.close()
}

class B17472(private val n: Int, private val m: Int) {
    private val map = Array(n) { IntArray(m) }
    private lateinit var visit: Array<BooleanArray>
    private val pq = PriorityQueue<Edge>(compareBy { it.weight })
    private lateinit var parents: IntArray

    private data class Edge(
        val from: Int,
        val to: Int,
        val weight: Int
    )

    companion object {
        private val dr = intArrayOf(0, 0, 1, -1)
        private val dc = intArrayOf(-1, 1, 0, 0)
    }

    fun input() {
        for (i in 0 until n) {
            with(StringTokenizer(br.readLine())) {
                for (j in 0 until m) {
                    map[i][j] = nextToken().toInt()
                }
            }
        }
    }

    fun findIsland() {
        visit = Array(n) { BooleanArray(m) }
        var islandNum = 2

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    bfs(i to j, islandNum)
                    islandNum++
                }
            }
        }

        parents = IntArray(islandNum - 1) { it }
    }

    private fun bfs(start: Pair<Int, Int>, islandNum: Int) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(start)
        visit[start.first][start.second] = true
        map[start.first][start.second] = islandNum

        while (queue.isNotEmpty()) {
            val (r, c) = queue.poll()

            repeat(4) {
                val nr = r + dr[it]
                val nc = c + dc[it]

                if (nr in 0 until n && nc in 0 until m && !visit[nr][nc] && map[nr][nc] == 1) {
                    map[nr][nc] = islandNum
                    visit[nr][nc] = true
                    queue.offer(nr to nc)

                }
            }
        }
    }

    fun makeGraph() {
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] != 0) checkBridge(i, j, map[i][j])
            }
        }
    }

    private fun checkBridge(r: Int, c: Int, islandNum: Int) {
        val queue = LinkedList<Triple<Int, Int, Int>>()
        visit = Array(n) { BooleanArray(m) }

        repeat(4) {
            queue.offer(Triple(r, c, 0))
            visit[r][c] = true

            while (queue.isNotEmpty()) {
                val (curR, curC, length) = queue.poll()

                val nr = curR + dr[it]
                val nc = curC + dc[it]

                if (nr in 0 until n && nc in 0 until m && !visit[nr][nc] && map[nr][nc] != islandNum) {
                    if (map[nr][nc] != 0) {
                        if (length > 1) {
                            val from = islandNum - 1
                            val to = map[nr][nc] - 1
                            pq.offer(Edge(from, to, length))
                            break
                        }
                    } else {
                        visit[nr][nc] = true
                        queue.offer(Triple(nr, nc, length + 1))
                    }
                }
            }

            queue.clear()
        }
    }

    fun kruskal(): Int {
        var sum = 0

        while (pq.isNotEmpty()) {
            val (a, b, weight) = pq.poll()

            if (find(a) != find(b)) {
                sum += weight
                union(a, b)
            }
        }

        val root = parents[1]
        for (v in 2..parents.lastIndex) {
            if (find(parents[v]) != root) return -1
        }

        return if (sum == 0) -1 else sum
    }

    private fun find(x: Int): Int {
        return if (x == parents[x]) x
        else {
            parents[x] = find(parents[x])
            parents[x]
        }
    }

    private fun union(a: Int, b: Int) {
        val aP = parents[a]
        val bP = parents[b]

        if (aP != bP) {
            if (aP < bP) parents[bP] = aP
            else parents[aP] = bP
        }
    }
}