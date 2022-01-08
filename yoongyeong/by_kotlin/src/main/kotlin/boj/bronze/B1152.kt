package boj.bronze

// 단어의 개수

import java.io.*
import java.util.*

fun main() {
    val list = readLine()!!.trim().split(" ")
    if (list[0] == "") print("0")
    else print(list.size)
}

private fun solution() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())

    bw.write("$st.countTokens()")

    bw.flush(); br.close(); bw.close()
}