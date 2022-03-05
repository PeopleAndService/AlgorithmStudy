package twopointer_prefixsum

// 소수의 연속합

fun main() {
    val n = System.`in`.bufferedReader().readLine().toInt()
    val array = sosu(n); val arraySize = array.size
    var start = 0; var end = 1; var result = 0

    while (end in start until arraySize) {
        (array[end] - array[start]).run {
            when {
                this == n -> { result++; start ++; end++ }
                this > n -> start++
                else -> end++
            }
        }
    }
    print(result)
}

private fun sosu(n: Int) : IntArray{
    val isSosu = BooleanArray(n+1) {true}
    for (i in 2 .. kotlin.math.sqrt(n.toDouble()).toInt()) {
        if (isSosu[i]) {
            var j = 2
            while (i * j <= n) isSosu[i * j++] = false
        }
    }

    val list = mutableListOf(0)
    for (i in 2 .. n) if (isSosu[i]) list.add(i + list.last())

    return list.toIntArray()
}