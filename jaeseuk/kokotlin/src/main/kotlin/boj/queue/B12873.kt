package boj.queue

import kotlin.math.pow

fun main() {
    val people = ArrayDeque<Int>()

    repeat(readLine()!!.toInt()) {
        people.add(it + 1)
    }

    var step = 1.0

    while (people.size != 1) {
        people.rotate(step)
        people.removeLast()
        step++
    }

    println(people.first())
}

fun ArrayDeque<Int>.rotate(step: Double) {
    repeat((step.pow(3) % this.size).toInt()) {
        this.addLast(this.removeFirst())
    }
}