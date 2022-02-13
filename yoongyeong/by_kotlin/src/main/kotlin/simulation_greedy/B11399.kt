package simulation_greedy

// ATM

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val atms = br.readLine().split(" ").map { it.toInt() }.sorted().toTypedArray()

    for (index in 1 until n) { atms[index] += atms[index-1] }

    print(atms.sum())
}