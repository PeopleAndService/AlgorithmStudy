package kotlin200Q

import java.lang.Exception
import java.lang.NumberFormatException

fun main(args: Array<String>) {
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

    val pt = Point(3, 6) from Point(1, 1)
    println("pt.x: ${pt.x}, pt.y: ${pt.y}")

    val person2 = Person2("홍길동", 35)
    val student: Person2 = Student("김길동", 23, 20171217)

    val obj: Person1? = null
    obj?.name = "김밥"

    println("student is Student : ${student is Student}")
    println("student is Person2 : ${student is Person2}")

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

class Point(var x: Int = 0, var y: Int = 0) {
    infix fun from (base: Point) = Point(x-base.x, y-base.y)
}

open class Person2(val name: String, val age: Int)
class Student(name: String, age: Int, val id: Int): Person2(name, age)

open class AAA(open val number: Int = 0) {
    open fun func() = println("AAA")
}

class BBB: AAA() {
    override var number: Int = 0
    get() = super.number
    set

    override fun func() {
        super.func()
        println("BBB")
    }
}

fun tryCatch(){
    try {
        val str = "abcd"
        val num = str.toInt()
        println(num)
    } catch (e: NumberFormatException) {
        println("문자열을 숫자로 변경하지 못함")
    } finally {
        println("프로그램 종료")
    }
}

fun throwTest() {
    try {
        something()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun something() {
    val num1 = 10
    val num2 = 0
    div(num1, num2)
}

fun div(a: Int, b: Int): Int {
    if (b == 0) throw Exception("0으로 나눌 수 없습니다.")
    return a / b
}