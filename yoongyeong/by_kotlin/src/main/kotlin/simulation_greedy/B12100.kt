package simulation_greedy

import java.util.StringTokenizer

// 2048 (Easy)

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()

private var answer = 0

fun main() {
    val graph = Array(n) { with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } } }
    dfs(graph)
    print(answer)
}

private fun dfs(graph: Array<IntArray>, cnt: Int = 0) {
    if (cnt == 5) { // 최대 다섯번 이동
        for (i in 0 until  n) {
            answer = answer.coerceAtLeast(graph[i].maxOrNull() ?: 0)
        }
        return
    }

    for (i in 0 until 4) {
        //copy
        val temp = Array(n){ IntArray(n) }
        for(r in 0 until n){
            for(c in 0 until n){
                temp[r][c]=graph[r][c]
            }
        }

        when (i) {
            // 0, 1, 2, 3 -> 상, 하, 좌, 우
            0 -> {
                for (c in 0 until n) {
                    for (r in 0 until n - 1) {
                        if (temp[r][c] != 0) { // 현재 칸에 블럭이 있는 경우 합치기
                            var idx = r + 1
                            while (idx < n && temp[idx][c] == 0) { // 아래의 처음 블럭
                                idx++
                            }
                            if (idx == n) break // 아래에 블럭이 없는 경우
                            if (temp[r][c] == temp[idx][c]) { //숫자가 같은 경우
                                temp[r][c] *= 2.also { temp[idx][c] = 0 }
                            } else {
                                temp[r + 1][c] = temp[idx][c].also { temp[idx][c] = 0 }
                            }
                        }
                    }
                    for (r in 0 until n - 1) {
                        if (temp[r][c] == 0) { //현재 칸에 블럭이 없는 경우 swap
                            var idx = r + 1
                            while (idx < n && temp[idx][c] == 0) { // 아래의 처음 블럭
                                idx++
                            }
                            if (idx == n) break // 아래에 블럭이 없는 경우
                            temp[r][c] = temp[idx][c].also { temp[idx][c] = 0 } // 아래에 블럭이 있는 경우
                        }
                    }
                }
            }
            1 -> {
                for (c in 0 until n) {
                    for (r in n - 1 downTo 1) {
                        if (temp[r][c] != 0) {
                            var idx = r - 1
                            while (idx >= 0 && temp[idx][c] == 0) {
                                idx--
                            }
                            if (idx < 0) break
                            if (temp[r][c] == temp[idx][c]) {
                                temp[r][c] *= 2.also { temp[idx][c] = 0 }
                            } else {
                                temp[r - 1][c] = temp[idx][c].also { temp[idx][c] = 0 }
                            }
                        }
                    }
                    for (r in n - 1 downTo 1) {
                        if (temp[r][c] == 0) {
                            var idx = r - 1
                            while (idx >= 0 && temp[idx][c] == 0) {
                                idx--
                            }
                            if (idx < 0) break
                            temp[r][c] = temp[idx][c].also { temp[idx][c] = 0 }
                        }
                    }
                }
            }
            2 -> {
                for (r in 0 until n) {
                    for (c in 0 until n - 1) {
                        if (temp[r][c] != 0) {
                            var idx = c + 1
                            while (idx < n && temp[r][idx] == 0) {
                                idx++
                            }
                            if (idx == n) break
                            if (temp[r][c] == temp[r][idx]) {
                                temp[r][c] *= 2.also { temp[r][idx] = 0 }
                            } else {
                                temp[r][c + 1] = temp[r][idx].also { temp[r][idx] = 0 }
                            }
                        }
                    }
                    for (c in 0 until n - 1) {
                        if (temp[r][c] == 0) {
                            var idx = c + 1
                            while (idx < n && temp[r][idx] == 0) {
                                idx++
                            }
                            if (idx == n) break
                            temp[r][c] = temp[r][idx].also { temp[r][idx] = 0 }
                        }
                    }
                }
            }
            3 -> {
                for (r in 0 until n) {
                    for (c in n - 1 downTo 1) {
                        if (temp[r][c] != 0) {
                            var idx = c - 1
                            while (idx >= 0 && temp[r][idx] == 0) {
                                idx--
                            }
                            if (idx < 0) break
                            if (temp[r][c] == temp[r][idx]) {
                                temp[r][c] *= 2.also { temp[r][idx] = 0 }
                            } else {
                                temp[r][c - 1] = temp[r][idx].also { temp[r][idx] = 0 }
                            }
                        }
                    }
                    for (c in n - 1 downTo 1) {
                        if (temp[r][c] == 0) {
                            var idx = c - 1
                            while (idx >= 0 && temp[r][idx] == 0) {
                                idx--
                            }
                            if (idx < 0) break
                            temp[r][c] = temp[r][idx].also { temp[r][idx] = 0 }
                        }
                    }
                }
            }
        }

        dfs(temp, cnt + 1)
    }
}