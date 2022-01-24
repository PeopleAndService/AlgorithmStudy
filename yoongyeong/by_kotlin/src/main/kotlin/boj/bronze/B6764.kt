package boj.bronze

// Sounds fishy!

fun main() {
    val (a, b, c, d) = List(4) { readLine()!!.toInt()}
    if (b-a>0&&c-b>0&&d-c>0) print("Fish Rising")
    else if(a==b&&b==c&&c==d) print("Fish At Constant Depth")
    else if(b-a<0&&c-b<0&&d-c<0) print("Fish Diving")
    else print("No Fish")
}