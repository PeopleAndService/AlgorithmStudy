package kotlin200Q

import java.text.FieldPosition

typealias NewInt = Int

class Part1 {
}

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

    val person = object {
        val name: String = "홍길동"
        val age: Int = 36
    }

    println(person.name)

    println("${Time(15, 6).second} 초")
    println("${Time(6, 3, 17).second} 초")

    val person1 = Person1("Kotlin", "2016-02-15")
    println(person1[0])
    println(person1[1])
    println(person1[-1])

    person1[0] = "Java"
    println(person1.name)
    person1(60)

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

class Person constructor(name: String, age: Int) {
    val name: String
    val age: Int

    init {
        this.name = name
        this.age = age
    }
}

class Car(val name: String, val speed: Int = 0)

class Time(val second: Int) {
    init {
        println("init 블록 실행 중")
    }

    constructor(minute: Int, second: Int): this(minute * 60 + second) {
        println("보조 생성자 1 실행 중")
    }

    constructor(hour: Int, minute: Int, second: Int): this(hour * 60 + minute, second) {
        println("보조 생성자 2 실행 중")
    }

    init {
        println("또 다른 init 블록 실행 중")
    }
}

class Person1(var name: String, var birthday: String) {
    operator fun get(position: Int): String = when (position) {
        0 -> name
        1 -> birthday
        else -> "알 수 없음"
    }

    operator fun set(position: Int, value: String) {
        when (position) {
            0 -> name = value
            1 -> birthday = value
        }
    }

    operator fun invoke(value: Int) {
        println(value)
        println("name: $name, birthday: $birthday")
    }
}