package baekjoon.simulation_greedy

// 잃어버린 괄호

fun main() {
    val line = readLine()
    val formulas = line!!.split("-")
    var result = if (line[0] == '-') 0
    else formulas[0].split("+").sumOf { it.toInt() }

    for (index in 1 until formulas.size) {
        result -= formulas[index].split("+").sumOf { it.toInt() }
    }

    print(result)
}