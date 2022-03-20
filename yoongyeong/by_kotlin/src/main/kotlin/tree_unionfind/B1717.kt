package tree_unionfind

import java.util.StringTokenizer

// 집합의 표현

private lateinit var parents: IntArray

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); m = nextToken().toInt()
    }
    parents = IntArray(n+1) {it}

    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            if (nextToken().toInt() == 0) union(nextToken().toInt(), nextToken().toInt())
            else bw.write(if(find(nextToken().toInt()) == find(nextToken().toInt())) "YES\n" else "NO\n")
        }
    }

    bw.close(); br.close()
}

private fun union(a: Int, b: Int) {
    val aParent = find(a)
    val bParent = find(b)
    if (aParent > bParent) parents[aParent] = bParent
    else parents[bParent] = aParent
}

private fun find(x: Int) : Int{
    if (parents[x] != x) parents[x] = find(parents[x])
    return parents[x]
}