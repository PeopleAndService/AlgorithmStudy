package kotlin200Q

import java.util.Timer
import kotlin.concurrent.thread
import kotlin.concurrent.timer
import kotlin.system.measureNanoTime

fun main() {
    val (a, b) = 1 to 4
    val (c, d) = Pair(1, 5)
    val (x, y, z) = Triple(1, 2, 3)
    println("$a $b $c $d $x $y $z")

    rectMain()
    closedRangeMain()
    progressionMain()
    collectionMain()
    listMain()
    mapMain()
    mutableCollectionMain()
    sequenceMain()
    collectionExtensionMain()
    charSequenceMain()
    stringMain()
    stringMain()

    // 어디서든 main() 종료하기 exitProcess(0)

    println(measureNanoTime { // or measureTimeMillis
        var sum = 0L
        for (i in 1..100000000) sum += i
    })
}

// comparable 인터페이스 (비교연산자 지원)
class Rect(val width: Int, val height: Int): Comparable<Rect> {
    val area = width * height
    override fun compareTo(other: Rect): Int =
        when {
            this.area > other.area -> 1
            this.area < other.area -> -1
            else -> 0
        }
}

fun rectMain() {
    println("comparable interface 학습")
    val rect = Rect(3, 5)
    val rect2 = Rect(7, 3)
    val rect3 = Rect(2, 9)

    println(rect >= rect3)
    println(rect < rect2)
    println(rect2 > rect3)
}

// ClosedRange 인터페이스, Iterable 인터페이스
fun closedRangeMain() {
    println("ClosedRange, Iterable interface 학습")
    val intRange = 1..10
    val longRange = 1L..100L
    val charRange = 'A'..'Z'

    println("${intRange.start} ${intRange.first}")
    println("${longRange.endInclusive} ${longRange.last}")
    println('*' in charRange)
    println(charRange.isEmpty())
}

// Progression 과 관련한 함수
fun IntProgression.print() {
    print("first: ${this.first}, ")
    print("last: ${this.last}, ")
    print("step: ${this.step} \n")

    for (i in this) print("$i ")
    print("\n")
}

fun progressionMain() {
    println("Progression 과 관련한 함수 학습")
    val prog = 7 downTo 3
    val prog2 = (3..7).reversed()
    prog.print(); prog2.print()
    println(prog == prog2)
    val prog3 = (1..10) step 3
    val prog4 = 10 downTo 2 step 3
    val prog5 = 2 until 5
    prog3.print(); prog4.print(); prog5.print()
}

// 코틀린의 컬렉션
fun collectionMain() {
    println("코틀린의 컬렉션 학습")
    val list: Collection<Int> = listOf(10, 20, 10)
    val set: Collection<Int> = setOf(1, 2, 3, 2, 3)
    val map: Map<String, String> = mapOf("Apple" to "사과", "Banana" to "바나나")
    println(list)
    println(set)
    println(map)
    println(list.size)
    println(list.isEmpty())
    println(20 in list)
    for (i in list) print("$i ")
    println()
}

// 코틀린의 리스트
fun listMain() {
    println("코틀린의 리스트 학습")
    val list: List<Double> = listOf(20.18, 1.14, 9.15, 1.14)
    println(list[0])
    println(list.indexOf(1.14))
    println(list.indexOf(9.31))
    println(list.lastIndexOf(1.14))
    println(list.subList(0,3))
}

// 코틀린의 Map
fun mapMain() {
    println("코틀린의 Map 학습")
    val map: Map<String, String> = mapOf("Apple" to "사과", "Banana" to "바나나")
    println(map.size)
    println(map.keys)
    println(map.values)
    println(map.entries)
    println(map.isEmpty())
    println(map.containsKey("Cocoa"))
    println(map.containsValue("바나나"))
    println(map["Apple"])
    println(map.getOrDefault("Cocoa", "코코아"))
}

// 변경할 수 있는 Mutable 컬렉션
fun mutableCollectionMain() {
    println("변경할 수 있는 Mutable 컬렉션 학습")
    val mutableList: MutableCollection<Int> = mutableListOf(1, 2, 4, 2, 3, 2, 5)
    println(mutableList)
    mutableList.add(1); println(mutableList)
    mutableList.addAll(listOf(2, 3, 4)); println(mutableList)
    mutableList.remove(1); println(mutableList)
    mutableList.removeAll(listOf(1, 2)); println(mutableList)
    mutableList.clear(); println(mutableList)

    val list = mutableListOf('c', 'a', 'z')
    println(list)
    list.add(1, '%'); println(list)
    list.addAll(0, listOf('L', 'P')); println(list)
    println(list.set(2, '/')); println(list)
    println(list.removeAt(4)); println(list)

    val set: MutableSet<Int> = mutableSetOf(1, 5, 7)
    println(set)
    println(set.add(5)); println(set)
    println(set.addAll(listOf(3, 7))); println(set)
}

// Sequence (게으른 list)
fun sequenceMain() {
    println("Sequence 학습")
    val seq: Sequence<Int> = sequenceOf(1, 2, 3)
    for (i in seq) print("$i ")
    println()
}

// 컬렉션 확장 함수
fun collectionExtensionMain() {
    println("Collection Extension 학습")
    val origin = listOf(65, 66, 67, 68, 69)
    println(origin.map {it.toChar()})
    println(origin.mapIndexed{index, element ->
        println("[$index]: $element")
        element.toChar()
    })
    val to100 = 1..100
    println(to100.mapNotNull {
        if(it % 3 == 0) it
        else null
    })

    val to50 = 1..50
    println(to50.filter { it % 4 == 0 })
    println(to50.filterNot { it % 4 == 0 })
    println(to50.filterNotNull())
    println(to50.filterIndexed{index, element -> element > 20})
    println(to50.filterIsInstance<Long>())

    val list = listOf(43, 76, 28, 19, 22, 68)
    println(list.sorted())
    println(list.sortedDescending())
}

// CharSequence 인터페이스
fun charSequenceMain() {
    println("CharSequence 인터페이스 학습")
    val seq: CharSequence = "Hello"
    println(seq.length)
    println(seq[2])
    println(seq.subSequence(1, 4))

    val str: CharSequence = "https://www.naver.com"
    println(str.startsWith("https://"))
    println(str.endsWith(".com"))
    println(str.removePrefix("https://"))
    println(str.removeSuffix(".com"))
    println(str.removeSurrounding("https://", ".com"))

    val emptyStr = ""
    val whiteSpaces = " "
    val nullStr: String? = null
    println(emptyStr.isEmpty())
    println(whiteSpaces.isEmpty())
    println(emptyStr.isBlank())
    println(whiteSpaces.isBlank())
    println(nullStr.isNullOrEmpty())
    println(nullStr.isNullOrBlank())

    val str1 = "   hello   "
    println(str1.removeRange(0..5))
    println(str1.padStart(20, '*'))
    println(str1.padEnd(17, '*'))
    println(str1.trimStart())
    println(str1.trimEnd())
    println(str1.trim())
    println(str1.slice(4..6))
    println(str1.subSequence(4..6))
    println(str1.substring(4..6))
    println(str1.reversed())

    val hello: CharSequence = "안녕하세요.\n고맙습니다.\n반갑습니다."
    val time: CharSequence = "2018-01-22"

    println(hello.lines())
    for (line in hello.lineSequence()) println(line)
    println(time.split("-"))

}

// String 예제
fun stringMain() {
    println("String 학습")

    val one = "Hello"
    val two = "Kotlin"
    val three = "JavaFx"
    println(one + two)
    println(one > two)
    println(two > three)

    val adage = "Love begets love."
    println(adage.replace("love", "hate", ignoreCase = true))
    println(adage.replaceFirst("love", "compliment", ignoreCase = true))
    println(adage.replaceRange(5..10, "hello"))
}

fun runMain() {
    println("run, let,  확장함수 학습")

    val (a, b) = 10 to 5
    (a * b - 2 * a).run {
        if (this > 0) println(this)
    }

    (a * b - 2 * a).let { result: Int ->
        if (result > 0) println(result)
    }

    val (c, d) = 3 to 7
    with(a * b - b* b) {
        println(this)
        println(-this)
    }
}

fun threadMain() {
    thread (start = true){
        print("Hello, ")
        Thread.sleep(1000)
        println("World!")
    }
    Thread.sleep(500)
    print("Kotlin ")
}

fun timerMain() {
    var i = 1
    val t: Timer = timer(initialDelay = 1500, period = 250) {
        println(i++)
    }
    Thread.sleep(2400)
    t.cancel()
}

// 스레드 동기화하기
private var obj = 0

private fun objPlus() {
    for (i in 1..1000) synchronized(obj) { obj++}
}

fun synchronizedMain() {
    thread { objPlus() }
    objPlus()
    Thread.sleep(100)
    println(obj)
}