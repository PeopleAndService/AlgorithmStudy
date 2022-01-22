package kotlin200Q

enum class Mode {SELECTION, PEN, SHAPE, ERASER}

fun main(args: Array<String>){
    People.name = "Singleton"
    People.age = 45
    People.print()

    val a = ObjPerson.create()
    val b = ObjPerson.Companion.create()
    println(ObjPerson.countCreated)

    val empty: String? = null
    empty.isNumber()

    val c = ObjPerson.created()

    val test: AA = BB()
    test.hi()
    test.hello()

    Child().follow()

    val nestInstance: Outer.Nested = Outer.Nested()
    nestInstance.hello()

    val instance: Outer = Outer(610)
    val innerInstance: Outer.Inner = instance.Inner(40)
    innerInstance.print()

    val employee = Employee("John", 30, 3300)
    val (name, _, salary) = employee
    println("name: $name, salary: $salary")

    val inf: Double = Double.POSITIVE_INFINITY

    referenceEx()

    val f: () -> Unit = returnFunc(30)
    f()

    val makeSure: Int.(left: Int, right: Int) -> Int
    makeSure = {left, right ->
        when {
            this < left -> left
            this > right -> right
            else -> this
        }
    }

    println(15.makeSure(20, 40))
    println(18.makeSure(0, 50))
    println(25.makeSure(0, 19))

    val func:() -> Int = toFunction<Int>(1107)
    println(func())

    val pair = Pair1<Int, Double>(15, 0.12)
    println(pair.toString())

    val words = arrayOf("Whats", "Your", "Number")
    printAll(*words)

    val mode = Mode.PEN
    when(mode) {
        Mode.SELECTION -> println("선택 모드")
        Mode.PEN -> println("펜 모드")
        Mode.SHAPE -> println("도형 모드")
        Mode.ERASER -> println("지우개 모드")
    }

    val outers: Outers = Outers.Three()
    val text: String = when (outers) {
        is Outers.One -> "첫번째"
        is Outers.Two -> "두번째"
        is Outers.Three -> "세번째"
    }
    println(text)
}

object People {
    var name: String = ""
    var age: Int = 0
    fun print(){
        println(name)
        println(age)
    }
}

class ObjPerson private constructor(){
    companion object {
        fun create(): ObjPerson{
            countCreated += 1
            return ObjPerson()
        }

        var countCreated = 0
            private set
    }
}

fun String?.isNumber(){
    if (this == null) println("문자열이 null 입니다.")
}

fun ObjPerson.Companion.created() = ObjPerson

open class AA {
    open fun hi() { println("멤버 함수 AA")}
}
class BB: AA() {
    override fun hi() { println("멤버 함수 BB") }
}

fun AA.hello() = println("확장 함수 AA")
fun BB.hello() = println("확장 함수 BB")

interface Parent {fun follow(): Unit}

interface Mother: Parent {
    override fun follow() {
        println("follow his mother")
    }
}

interface Father: Parent {
    override fun follow() {
        println("follow his father")
    }
}

class Child: Mother, Father {
    override fun follow() {
        println("A child decided to")
        super<Mother>.follow()
        super<Father>.follow()
    }
}

class Outer(private val value: Int) {
    fun print() {println("outer value : ${ this.value }")}

    class Nested {fun hello() = println("중첩된 클래스")}

    inner class Inner(private val innerValue: Int) {
        fun print() {
            this@Outer.print()
            println("sum value : ${ this.innerValue + this@Outer.value }")
        }
    }
}

data class Employee(val name: String, val age: Int, val salary: Int)

fun literal() {
    val instantFunc: (Int) -> Unit
    instantFunc = {number: Int ->
        println("Hello $number")
    }
    instantFunc(33)
    instantFunc.invoke(33)
}

fun anonymous_ex() {
    val instanceFunc: (Int) -> Unit = fun(number: Int): Unit{
        println("Hello $number")
    }
}

fun plus(a: Int, b: Int) = println("plus 호출됨 ${a+b}")

object Object {fun minus(a: Int, b: Int) = println("Object의 minus 호출됨 ${a-b}")}

class Class {fun average(a: Int, b: Int) = println("Class average 호출됨 ${(a+b)/2}")}

fun referenceEx() {
    println("함수 참조 예제")
    var instanceFunc: (Int, Int) -> Unit
    instanceFunc = ::plus
    instanceFunc(60, 27)

    instanceFunc = Object::minus
    instanceFunc(36, 12)

    instanceFunc = Class()::average
    instanceFunc(25, 15)
}

fun decorate(task: () -> Unit) {
    println("===작업 시작===")
    task()
    println("===작업 끝===")
}

fun higherOrderEx() {
    decorate {
        val a = 10; val b = 5
        println("$a + $b = ${a+b}")
    }
    decorate({
        println("some")
        println("tasks")
    })
}

fun returnFunc(num: Int): () -> Unit = { println(num)}

fun <T> toFunction(value: T): () -> T = {value}

class Pair1<A, B>(val first: A, val second: B) {
    override fun toString() = "$first\n$second"
}

interface Plusable<T> {
    operator fun plus(other: T): T
}

class Rectangle(val width: Int, val height: Int): Plusable<Rectangle> {
    override fun plus(other: Rectangle) = Rectangle(width + other.width, height + other.height)
    override fun toString() = "width: $width, height: $height"
}

fun printAll(vararg tokens: String) {
    for (token in tokens) print("$token ")
}

sealed class Outers {
    class One: Outers()
    class Two: Outers()
    class Three: Outers()
}