package boj.bronze

// Speed fines are not fine!

fun main() {
    val (a, b) = List(2) { readLine()!!.toInt()}
    if (a >= b) print("Congratulations, you are within the speed limit!")
    else {
        val fine = if (b-a in 1..20) 100 else if (b-a in 21..30) 270 else 500
        print("You are speeding and your fine is $$fine.")
    }
}