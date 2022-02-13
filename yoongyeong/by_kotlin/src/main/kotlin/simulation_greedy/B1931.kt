package simulation_greedy

// 회의실 배정

private val br = System.`in`.bufferedReader()

fun main() {
    val meetingRooms = mutableListOf<Pair<Int, Int>>()
    var endTime = 0
    var result = 0

    repeat(br.readLine().toInt()) {
        br.readLine().split(" ").run {
            meetingRooms.add(Pair(first().toInt(), last().toInt()))
        }
    }
    meetingRooms.sortWith(compareBy({it.second}, {it.first}))

    for (index in 0 until meetingRooms.size) {
        if (meetingRooms[index].first >= endTime) {
            endTime = meetingRooms[index].second
            result++
        }
    }

    print(result)
}