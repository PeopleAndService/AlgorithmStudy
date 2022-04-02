package trie_hash

import java.util.StringTokenizer

// 문자열 집합

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); m = nextToken().toInt()
    }
    val trie = Trie()

    for (i in 0 until n) {
        trie.insert(br.readLine())
    }

    for (i in 0 until m) {
        trie.search(br.readLine())
    }

    print(trie.count)

}

private class Trie {
    var count = 0
    var char: Char? = null
    var next = Array<Trie?>(26) { null }
    var isFinish = false

    fun insert(value: String) {
        var cur = this
        for (char in value) {
            val idx = char - 'a'
            if (cur.next[idx] == null) {
                cur.next[idx] = Trie()
            }
            cur = cur.next[idx]!!
            cur.char = char
        }
        cur.isFinish = true
    }

    fun search(str: String) {
        var cur = this
        var flag = true
        for (char in str) {
            val idx = char - 'a'
            if (cur.next[idx] == null) {
                flag = false
                break
            }
            cur = cur.next[idx]!!
        }

        if (flag && cur.isFinish) count++
    }
}

/*private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()
private val set = HashSet<String>()

fun main(){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    var answer=0
    for(i in 0 until n){
        set.add(br.readLine())
    }
    for(i in 0 until m){
        if(set.contains(br.readLine()))
            answer++
    }

    bw.write("$answer")
    bw.close()
}*/