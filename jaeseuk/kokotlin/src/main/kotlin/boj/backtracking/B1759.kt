package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var l = 0
private var c = 0

private lateinit var chars: List<String>
private val vowel = setOf("a", "e", "i", "o", "u")

fun main() {
    br.readLine().split(" ").run {
        l = first().toInt()
        c = last().toInt()
    }

    chars = br.readLine().split(" ").sorted()

    secret(0, 0, 0, "")

    bw.flush()
    bw.close()
}

private fun secret(idx: Int, v: Int, o: Int, s: String) {
    if (idx == c) {
        if (s.length == l && v >= 1 && o >= 2) {
            bw.append("$s\n")
        }

        return
    }

    if (chars[idx] in vowel) secret(idx + 1, v + 1, o, s + chars[idx])
    else secret(idx + 1, v, o + 1, s + chars[idx])
    secret(idx + 1, v, o, s)
}