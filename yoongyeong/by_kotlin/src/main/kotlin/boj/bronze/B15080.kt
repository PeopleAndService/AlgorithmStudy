package boj.bronze

// Every Second Counts

fun main() {
    val (t1, t2) = List(2) {readLine()!!.split(" : ").map {it.toInt()}.let { (a,b,c)->a*3600+b*60+c}}
    print(if(t1>t2)t2-t1+86400 else t2-t1)
}