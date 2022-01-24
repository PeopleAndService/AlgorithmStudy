package boj.bronze

// Darius님 한타 안함?

fun main()=print(if(readLine()!!.split("/").map { it.toInt() }.let { it[0]+it[2]<it[1] ||it[1]==0 })"hasu" else "gosu")