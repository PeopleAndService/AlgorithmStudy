package kotlin200Q

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