package boj.bronze

// 부녀회장이 될테야

fun main() {
    repeat(readLine()!!.toInt()) {
        val (a, b) = List(2) { readLine()!!.toInt()}
        var rooms = List(b) {it+1}.toMutableList()
        for (floor in 1..a) {
            val newRooms = mutableListOf(rooms[0])
            for (roomNum in 1 until b) newRooms.add(newRooms[roomNum - 1] + rooms[roomNum])
            rooms = newRooms
        }

        println(rooms[b-1])
    }
}