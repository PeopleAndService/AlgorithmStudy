package week9

import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

/*
플랫폼 : 백준
문제번호 : 1774
문제제목 : 우주신과의 교감
난이도 : 골드 3
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 최소 스패닝 트리

알고리즘 설명
1. 황선자씨와 우주신이 위치하는 좌표를 입력받는다. -> xInfo, yInfo
2. 이미 연결된 통로를 입력받는다 -> 가중치를 0으로 설정하고 그래프의 표현에는 인접행렬 사용
3. 각 정점(좌표정보)들에 대해서 좌표간의 거리를 가중치로 하는 통로 정보를 인접행렬에 입력한다.
-> 단, 이미 연결된 통로(0)에 대해서는 제외, 인접 그래프를 사용할 경우 시간, 메모리 복잡성이 증가해서 인접 행렬 사용
4. 프림 알고리즘 수행 -> 임의의 정점을 시작점으로 우선순위 큐에 정점과 가중치를 담아 가중치가 작은 정점을 우선 탐색 하도록 한다.
5. 방문 배열을 두어 이미 가중치가 최소로 갱신된 정점은 탐색하지 않도록 함
6. 이미 연결된 통로는 가중치가 0.0인 간선과 마찬가지 이므로 이를 포함해서 구해도 최소 신장 트리의 가중치는 필요한 통로의 길이만큼 나옴

채점 결과 : 848ms/59828KB
풀이 날짜 : 2022/03/24
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = with(StringTokenizer(br.readLine())) {
        B1774(nextToken().toInt(), nextToken().toInt())
    }

    inst.input()
    inst.makeGraph()
    val answer = inst.prim()

    bw.write(String.format("%.2f", answer))
    bw.close()
    br.close()
}

class B1774(private val n: Int, private val m: Int) {
    private val xInfo = IntArray(n + 1)
    private val yInfo = IntArray(n + 1)
    private val graph = Array(n + 1) { DoubleArray(n + 1) { Double.MAX_VALUE } }

    fun input() {
        for (i in 1..n) {
            with(StringTokenizer(br.readLine())) {
                xInfo[i] = nextToken().toInt()
                yInfo[i] = nextToken().toInt()
            }
        }
    }

    fun makeGraph() {
        repeat(m) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                graph[a][b] = 0.0
                graph[b][a] = 0.0
            }
        }

        for (i in 1 until n) {
            for (j in i + 1..n) {
                if (graph[i][j] == 0.0) continue

                val dist = calcDist(i, j)
                graph[i][j] = dist
                graph[j][i] = dist
            }
        }
    }

    fun prim(): Double {
        val pq = PriorityQueue<Pair<Int, Double>>(compareBy { it.second })
        val visit = BooleanArray(n + 1)
        var sum = 0.0
        pq.offer(1 to 0.0)

        while (pq.isNotEmpty()) {
            val (cur, weight) = pq.poll()

            if (!visit[cur]) {
                visit[cur] = true
                sum += weight
                for (next in 1..n) {
                    if (graph[cur][next] != Double.MAX_VALUE && !visit[next]) {
                        pq.offer(next to graph[cur][next])
                    }
                }
            }
        }

        return sum
    }

    private fun calcDist(from: Int, to: Int): Double {
        return sqrt((xInfo[from] - xInfo[to]).toDouble().pow(2) + (yInfo[from] - yInfo[to]).toDouble().pow(2))
    }
}