package boj.silver

// 크로아티아 알파벳

fun main() {
    val alphabet = readLine()!!
    var cnt = 0; var index = 0
    while (index < alphabet.length) {
        cnt += 1
        when (alphabet[index]) {
            'c' -> {
                index += if ((index + 1 < alphabet.length) && (alphabet[index+1] == '=' || alphabet[index+1] == '-')) 2
                else 1
            }
            'd' -> {
                index += if (index + 1 < alphabet.length && alphabet[index+1] == '-') 2
                else {
                    if (index + 2 < alphabet.length && alphabet.slice(index..index+2) =="dz=") 3
                    else 1
                }
            }
            'l', 'n' -> {
                index += if (index + 1 < alphabet.length && alphabet[index+1] == 'j') 2
                else 1
            }
            's', 'z' -> {
                index += if (index + 1 < alphabet.length && alphabet[index+1] == '=') 2
                else 1
            }
            else -> {index += 1}
        }
    }
    println(cnt)
}