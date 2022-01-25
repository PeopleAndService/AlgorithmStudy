package boj.bronze

// Betygsättning

fun main() {
    val (a, c, e) = readLine()!!.split(" ").map { it.toDouble() }
    val (aa, cc, ee) = readLine()!!.split(" ").map { it.toDouble() }
    when {
        aa>=a&&cc>=c&&ee>=e -> print("A")
        aa>=a/2 && cc>=c && ee>=e -> print("B")
        cc>=c && ee>=e -> print("C")
        cc>=c/2 && ee>=e/2 -> print("D")
        else -> print("E")
    }
}