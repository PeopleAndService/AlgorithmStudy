package boj.silver

// 괄호

fun main() {
    repeat(readLine()!!.toInt()) {
        var answer = 0
        for (c in readLine()!!) {
            if (c == '(') answer += 1
            else answer -= 1
            if (answer == -1) break
        }
        println(if(answer == 0) "YES" else "NO")
    }
}