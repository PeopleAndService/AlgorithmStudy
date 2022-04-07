package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer

//  정보 상인 호석

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val q = br.readLine().toInt()
    val gorillas = mutableMapOf<String, PriorityQueue<Int>>()

    var answer = 0L

    repeat(q) {
        with(StringTokenizer(br.readLine())) {
            val t = nextToken()
            val gorilla = nextToken()
            val k = nextToken().toInt()

            if (t == "1") {
                with(gorillas.getOrPut(gorilla) { PriorityQueue(compareBy { -it }) }) {
                    repeat(k) {
                        add(nextToken().toInt())
                    }
                }
            } else {
                gorillas[gorilla]?.let { information ->
                    repeat(minOf(k, information.size)) {
                        answer += information.poll()
                    }
                }
            }
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}