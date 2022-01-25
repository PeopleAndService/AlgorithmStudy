package boj.bronze

// Equality

fun main(){
    val str = readLine()!!
    if (str.slice(0..0).toInt()+str.slice(4..4).toInt()==str.slice(8..8).toInt()) print("YES")
    else print("NO")
}