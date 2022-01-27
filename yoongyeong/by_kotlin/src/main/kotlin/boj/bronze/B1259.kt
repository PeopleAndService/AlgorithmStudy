package boj.bronze

// 팰린드롬수

fun main() {
    var word = readLine()!!
    while (word != "0") {
        println(if (palindrome(word.slice(0 until word.length/2), word.slice(word.length/2+(if(word.length % 2 == 0)0 else 1) until word.length))) "yes"
        else "no")
        word = readLine()!!
    }
}

fun palindrome(first: String, second: String) = first == second.reversed()