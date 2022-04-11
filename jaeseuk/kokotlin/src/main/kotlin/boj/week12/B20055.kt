package boj.week12

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.StringTokenizer

//  컨베이어 벨트 위의 로봇

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val belt = LinkedList<Int>()
    val hasRobot = BooleanArray(n * 2)
    val robots = LinkedList<Int>()

    with(StringTokenizer(br.readLine())) {
        while (hasMoreTokens()) {
            belt.add(nextToken().toInt())
        }
    }

    var zero = 0
    var answer = 1

    while (true) {
        //  step 1
        belt.addFirst(belt.pollLast())

        for (i in robots.indices) {
            val next = (robots[i] + 1) % (n * 2)

            hasRobot[robots[i]] = false
            hasRobot[next] = true
            robots[i] = next
        }

        if (robots.isNotEmpty() && robots.peek() == n - 1) {
            hasRobot[robots.poll()] = false
        }

        //  step 2
        for (i in robots.indices) {
            val next = (robots[i] + 1) % (n * 2)

            if (belt[next] >= 1 && !hasRobot[next]) {
                hasRobot[robots[i]] = false
                hasRobot[next] = true

                if (--belt[next] == 0) zero++

                robots[i] = next
            }
        }

        if (robots.isNotEmpty() && robots.peek() == n - 1) {
            hasRobot[robots.poll()] = false
        }

        //  step 3
        if (belt.peek() != 0) {
            hasRobot[0] = true
            robots.add(0)

            if (--belt[0] == 0) zero++
        }

        //  step 4
        if (zero >= k) break
        else answer++
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}