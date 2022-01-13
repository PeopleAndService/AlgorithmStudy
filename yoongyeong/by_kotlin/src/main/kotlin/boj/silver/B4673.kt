package boj.silver

// 셀프 넘버

fun main() {
    val numbers = BooleanArray(10000)
    var idx = 1
    while (idx < 10000) {
        val newNum = d(idx)
        if (newNum != idx) numbers[newNum-1] = true
        idx += 1
    }

    for (i in numbers.indices) if(!numbers[i]) println(i+1)
}

fun d(n: Int): Int{
    val answer = when (n.toString().length) {
        1 -> n + n % 10
        2 -> n + n / 10 % 10 + n % 10
        3 -> n + n / 100 % 10 + n / 10 % 10 + n % 10
        4 -> n + n / 1000 % 10 + n / 100 % 10 + n / 10 % 10 + n % 10
        else -> n
    }
    return if (answer > 10000) n
    else answer
}