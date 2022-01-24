package boj.bronze

// Congruent Numbers

fun main() =print(if(readLine()!!.split(" ").map { it.toLong() }.let { (a,b,c,d) -> (a*c)%(2*b*d)==0L }) 1 else 0)
