package programmers.level1

class SortBoxers {
    fun solution(weights: IntArray, head2head: Array<String>): IntArray {
        val answer = arrayListOf<Array<Any>>()

        for (i in 0..weights.lastIndex) {
            val games = head2head[i].length - head2head[i].count { it == 'N' }
            val win = if (games > 0)
                head2head[i].count { it == 'W' }.toDouble() / games else 0
            val cnt = head2head[i].withIndex().count {
                it.value == 'W' && weights[i] < weights[it.index]
            }

            answer.add(arrayOf(win, cnt, weights[i], i + 1))
        }

        return answer
            .sortedWith(
                compareBy(
                    { -it[0].toString().toDouble() },
                    { -it[1].toString().toInt() },
                    { -it[2].toString().toInt() },
                    { it[3].toString().toInt() })
            )
            .map { it[3].toString().toInt() }.toIntArray()
    }
}