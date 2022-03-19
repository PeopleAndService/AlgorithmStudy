package tree_unionfind

import java.util.StringTokenizer

// 여행가자

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private val m = br.readLine().toInt()
private val parents = IntArray(n+1) { it }

fun main() {
    for (i in 0 until n) {
        with(StringTokenizer(br.readLine())) {
            for (j in 0 until n) {
                if (nextToken().toInt() == 1) union(i+1, j+1)
            }
        }
    }

    with(StringTokenizer(br.readLine())) {
        var a = 0; var b = nextToken().toInt()
        repeat(m-1) {
            a = b; b = nextToken().toInt()
            if (find(a) != find(b)) {
                println("NO")
                return
            }
        }
    }
    println("YES")
}

private fun union(a: Int, b: Int){
    val aParent = find(a)
    val bParent = find(b)
    if (aParent > bParent) parents[aParent] = bParent
    else parents[bParent] = aParent
}

private fun find(x: Int): Int {
    var parent = parents[x]
    while (parent != parents[parent]) parent = parents[parent]
    return parent
}