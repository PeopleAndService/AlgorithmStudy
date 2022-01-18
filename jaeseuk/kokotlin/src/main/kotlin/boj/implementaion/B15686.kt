package boj.implementaion

import kotlin.math.abs

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val chickens = mutableListOf<Pair<Int, Int>>()
    val houses = mutableListOf<Pair<Int, Int>>()

    repeat(n) { r ->
        readLine()!!.split(' ').mapIndexed { c, v ->
            val t = v.toInt()

            if (t == 1) {
                houses.add(r to c)
            } else if (t == 2) {
                chickens.add(r to c)
            }

            t
        }
    }

    val combinations = mutableListOf<MutableSet<Pair<Int, Int>>>()
    var answer = 1e9.toInt()
    makeCombinations(chickens, combinations, mutableSetOf(), m, 0)

    for (combination in combinations) {
        var sum = 0

        for (house in houses) {
            var dis = (n - 1) * 2

            for (chicken in combination) {
                dis = minOf(dis, abs(house.first - chicken.first) + abs(house.second - chicken.second))
            }

            sum += dis
        }

        answer = minOf(answer, sum)
    }

    println(answer)
}

private fun makeCombinations(
    ori: MutableList<Pair<Int, Int>>,
    combinations: MutableList<MutableSet<Pair<Int, Int>>>,
    combination: MutableSet<Pair<Int, Int>>,
    m: Int,
    start: Int
) {
    if (combination.size == m && combination !in combinations) {
        combinations.add(combination)
    } else {
        for (i in start..ori.lastIndex) {
            combination.add(ori[i])
            makeCombinations(ori, combinations, combination.toMutableSet(), m, i + 1)
            combination.remove(ori[i])
        }
    }
}