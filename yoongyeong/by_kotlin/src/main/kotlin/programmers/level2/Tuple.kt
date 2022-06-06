package programmers.level2

// 튜플 (2019 카카오 개발자 겨울 인턴쉽)

class Tuple {
    fun solution(s: String): IntArray {
        val sList = s
            .replace("{", "")
            .replace("}}","")
            .split("},")
            .map{it.split(",").map{it.toInt()}}

        val answer = IntArray(sList.size)
        val sortList = sList.sortedBy { it.size }

        answer[0] = sortList[0][0]
        for (idx in 1 until sortList.size) {
            answer[idx] = sortList[idx].subtract(sortList[idx-1]).first()
        }

        return answer
    }
}