package boj.bronze

// FYI

fun main() {
    val phoneNumber = readLine()!!
    print(if(phoneNumber[0]=='5'&&phoneNumber[1]=='5'&&phoneNumber[2]=='5') "YES"
    else "NO")
}