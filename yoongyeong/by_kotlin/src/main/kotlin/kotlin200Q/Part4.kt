package kotlin200Q

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