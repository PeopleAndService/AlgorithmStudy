package programmers.level2

import java.util.*

class Printer {
    fun solution(priorities: IntArray, location: Int): Int {
        var count = 0
        val sortedArray = priorities.sortedDescending()
        var sortedIndex = 0

        val queue = LinkedList<Pair<Int, Int>>()
        for ((index, priority) in priorities.withIndex()) {
            queue.add(Pair(index, priority))
        }

        while (queue.isNotEmpty()) {
            if (queue.first().second == sortedArray[sortedIndex]) {
                count ++
                if (queue.first().first == location) break
                queue.pollFirst()
                sortedIndex++
            } else {
                queue.add(queue.pollFirst())
            }
        }


        return count
    }
}