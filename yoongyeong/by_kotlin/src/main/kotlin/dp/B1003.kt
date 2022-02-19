package dp

// 피보나치 함수

fun main(){
    val br = System.`in`.bufferedReader(); val bw = System.out.bufferedWriter()
    val dp = Array(41) {Pair(1, 0)}
    dp[1] = Pair(0, 1)
    for (index in 2 .. 40) dp[index] = dp[index-1] plus dp[index-2]

    repeat(br.readLine().toInt()) {
        bw.write(dp[br.readLine().toInt()].let { "${it.first} ${it.second}\n" })
    }

    br.close(); bw.close()
}

private infix fun Pair<Int, Int>.plus(x: Pair<Int, Int>) = Pair(this.first+x.first, this.second+x.second)