package kotlin200Q

typealias NewInt = Int

fun main(args: Array<String>){
    println("Hello, Kotlin")
    53+62-126

    //var a: Int
    //println(a + 15)

    //val num: Double = 15 - 4*3

    var str: String = "Hello"
    println(str)

    str += "\nKotlin!"
    println(str)

    println(str[8])

    val num = 10 * 5 + 3
    println(str + num)

    var number: NewInt = 10

    var x = 0
    var y = 0

    outer@ while (x <= 20) {
        y = 0
        while (y <= 20) {
            if (x+y == 15 && x-y==5)
                break@outer
            y += 1
        }
        x += 1
    }

    println("x:$x, y:$y")

    println(getSumOf(1, 2, 3))
    println(getSumOf(5, 6))

}

fun getSumOf(vararg numbers: Int): Int {
    val count = numbers.size
    var i = 0; var sum = 0

    while (i < count) {
        sum += numbers[i]
        i += 1
    }

    return sum
}