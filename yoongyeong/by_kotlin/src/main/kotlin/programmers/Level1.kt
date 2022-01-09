package programmers

import kotlin.math.abs
import kotlin.math.pow

fun main(args: Array<String>): Unit {
    println(solution09(5))
    println(solution09x01(6))
}

// 두 정수 사이의 합
fun solution01(a: Int, b: Int): Long {
    var answer: Long = 0
    if (a < b) {
        for (i in a..b) answer += i
    } else {
        for (i in b..a) answer += i
    }
    return answer
}

fun solution01x01(a: Int, b: Int): Long =
    if (a < b) (a.toLong()..b.toLong()).sum()
    else (b.toLong()..a.toLong()).sum()

fun solution01x02(a: Int, b: Int): Long =
    (abs(a - b) + 1L) * (a + b) / 2L

// 없는 숫자 더하기
fun solution02(numbers: IntArray) = 45 - numbers.sum()

// 평균 구하기
fun solution03(arr: IntArray) = arr.sum() / arr.size.toDouble()

fun solution03x01(arr: IntArray) = arr.average()

// 음양 더하기
fun solution04(absolutes: IntArray, signs: BooleanArray): Int {
    var answer = 0
    for (i in signs.indices) {
        if (signs[i]) answer += absolutes[i]
        else answer -= absolutes[i]
    }
    return answer
}

fun solution04x01(absolutes: IntArray, signs: BooleanArray) =
    absolutes.foldIndexed(0) { idx, acc, num -> acc + if (signs[idx]) num else -num }

fun solution04x02(absolutes: IntArray, signs: BooleanArray): Int {
    val toIntSignsArray = signs.map { if (it) 1 else -1 }
    return absolutes.zip(toIntSignsArray).map { it.first * it.second }.sum()
}

// 내적
fun solution05(a: IntArray, b: IntArray) =
    a.zip(b).map { it.first * it.second }.sum()

// 나머지가 1이 되는 수 찾기
fun solution06(n: Int): Int {
    for (x in 2..n) {
        if (n % x == 1) return x
    }
    return n
}

fun solution07(n: Int): Int {
    var answer = 0
    var number = n
    val size = n.toString().length
    for (x in 1..size) {
        val share: Int = number / (10.0).pow(size-x).toInt()
        answer += share
        number -= share * (10.0).pow(size-x).toInt()
    }
    return answer
}

fun solution07x01(n: Int): Int {
    var answer = 0
    for (nn in n.toString()) {
        answer += (nn.toString()).toInt()
    }
    return answer
}

// 짝수와 홀수
fun solution08(num: Int) = if (num % 2 == 0) "Even" else "Odd"

fun solution08x01(num: Int) = if (num.and(1) == 0) "Even" else "Odd"

// 수박수박수박수박수박수?
fun solution09(n: Int): String = if (n % 2 == 0) "수박".repeat(n/2) else "수박".repeat(n/2) + "수"

fun solution09x01(n: Int): String = String(CharArray(n) { i -> if (i % 2 == 0) '수' else '박' })


// 직사각형 별 찍기
fun solution10() {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    for (i in 1..b) println("*".repeat(a))
}

// 하샤드 수
fun solution11(x: Int): Boolean {
    var answer = 0
    for (x_str in x.toString()) {
        answer += (x_str.toString()).toInt()
    }
    return x % answer == 0
}

fun solution11x01(x: Int): Boolean {
    return x % x.toString().fold(0){acc, c -> acc + c.toInt() - 48} == 0
}

// 핸드폰 번호 가리기
fun solution12(phone_number: String): String {
    return "*".repeat(phone_number.length-4) + phone_number.slice(phone_number.length-4 until phone_number.length)
}

fun solution12x01(phone_number: String): String {
    return "${"".padStart(phone_number.length - 4, '*')}${phone_number.takeLast(4)}"
}

// K번째 수
fun solution13(array: IntArray, commands: Array<IntArray>): IntArray {
    val answer = arrayListOf<Int>()
    for ((i, j, k) in commands) {
        answer.add(array.slice(i-1 until j).sorted()[k-1])
    }
    return answer.toIntArray()
}

fun solution13x01(array: IntArray, commands: Array<IntArray>): IntArray {
    return commands.map { (i, j, k) ->
        array.slice(i-1 until j).sorted()[k - 1]
    }.toIntArray()
}

// 3진법 뒤집기
fun solution14(n: Int) = n.toString(3).reversed().toInt(3)

// 부족한 금액 계산하기
fun solution15(price: Long, money: Int, count: Int): Long {
    val priceL = price.toLong()
    return if ((priceL * (count + 1) * count / 2) > money) (priceL * (count + 1) * count / 2 - money)
    else 0
}