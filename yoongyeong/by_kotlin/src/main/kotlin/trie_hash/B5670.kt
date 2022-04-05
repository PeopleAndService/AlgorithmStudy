package trie_hash

import java.util.TreeMap

// 휴대폰 자판

private var answer = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var n: String? = br.readLine()

    while (n != null && n.isNotBlank()) {
        val root = Trie5670()
        answer = 0
        repeat(n.toInt()) {
            var node = root.node
            for (char in br.readLine()) {
                node = node.map.getOrPut(char) { Node5670() }
            }
            node.endOfString = true
        }
        root.node.count(if(root.node.map.keys.size == 1)1 else 0)
        bw.write("${"%.2f".format(answer / n.toDouble())}\n")
        n = br.readLine()
    }
    bw.close()
}

private data class Trie5670(
    val node: Node5670 = Node5670(),
)

private data class Node5670(
    val map: TreeMap<Char, Node5670> = TreeMap<Char, Node5670>(),
    var endOfString: Boolean = false,
) {
    fun count(cnt: Int) {
        var childCnt = map.keys.size

        if (endOfString) {
            answer += cnt
            childCnt ++
        }

        for (char in map.keys) {
            map[char]?.count(if (childCnt == 1) cnt else cnt + 1)
        }
    }
}