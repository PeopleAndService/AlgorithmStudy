package binarysearch_parametricsearch

// 제곱근

fun main() {
    val n = readLine()!!.toBigInteger()
    var low = 0.toBigInteger(); var high = n / 2.toBigInteger()

    while (low <= high) {
        val mid = (low + high) / 2.toBigInteger()

        when {
            mid * mid == n -> { print("$mid"); return }
            mid * mid > n -> high = mid - 1.toBigInteger()
            else -> low = mid + 1.toBigInteger()
        }
    }
    print("1")
}