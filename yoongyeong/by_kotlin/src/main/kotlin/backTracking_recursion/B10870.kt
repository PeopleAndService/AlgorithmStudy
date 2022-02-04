package backTracking_recursion

// 피보나치 수 5

fun main() {
    print(fibonacci(readLine()!!.toInt()))
}

private fun fibonacci(n: Int): Int = if(n == 0) 0
    else if (n in 1..2) 1
    else fibonacci(n-1)+fibonacci(n-2)

private fun dpFibonacci(n: Int): Int {
    val array = IntArray(n+2)
    array[1] = 1
    for (i in 2..n) array[i] = array[i-1] + array[i-2]
    return array[n]
}