package baekjoon.stack_queue

// 후위 표기식 2

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val comments = br.readLine()
    val array = DoubleArray(n) { br.readLine().toDouble() }
    val stack = mutableListOf<Double>()

    for (comment in comments) {
        when (comment) {
            '+' -> stack.add(stack.removeLast() + stack.removeLast())
            '-' -> stack.add(-stack.removeLast() + stack.removeLast())
            '*' -> stack.add(stack.removeLast() * stack.removeLast())
            '/' -> stack.add(1 / stack.removeLast() * stack.removeLast())
            else -> stack.add(array[comment - 'A'])
        }
    }

    print("%.2f".format(stack.last()))
}