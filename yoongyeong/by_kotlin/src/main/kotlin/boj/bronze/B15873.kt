package boj.bronze

// 공백 없는 A+B

fun main() {
    val number = readLine()!!
    print(if (number.length == 4) 10 + 10
        else if (number.length == 3 && number[1] == '0') 10 + number.slice(2..2).toInt()
        else if (number.length == 3 && number[2] == '0') 10 + number.slice(0..0).toInt()
        else number.slice(0..0).toInt() + number.slice(1..1).toInt())
}