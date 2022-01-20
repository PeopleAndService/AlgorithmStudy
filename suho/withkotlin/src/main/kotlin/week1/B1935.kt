package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*
플랫폼 : 백준
문제번호 : 1935
문제제목 : 후위 표기식2
난이도 : 실버 3
제한사항 : 2초/128MB
알고리즘 분류 : 자료구조, 스택

알고리즘 설명
스택을 사용한 후위표기식 계산
1. 후위표기식을 읽으면서 피연산자를 만나면 스택에 삽입
2. 연산자를 만나면 스택에서 피연산자 두 개를 꺼내서 계산하고 삽입 -> 이 때 피연산자 위치는 나중에 꺼낸거 (연산자) 먼저 꺼낸거

채점 결과 : 96ms/12556KB
풀이 날짜 : 2022/01/20
*/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = stoi(br.readLine())
    val input = br.readLine()
    val operand = IntArray(n) { stoi(br.readLine()) } // 람다식을 배열 생성 팩토리 메소드로 사용했습니다.

    bw.write(String.format("%.2f", B1935(operand, input).solution()))
    bw.flush()
    bw.close()
    br.close()
}

fun stoi(arg: String): Int {
    return arg.toInt()
}

class B1935(private val operand: IntArray, private val exp: String) {
    private val answer = Stack<Double>()

    fun solution(): Double {
        for (cur in exp) {
            when (cur) {
                in 'A'..'Z' -> answer.push(operand[(cur - 'A')].toDouble()) // if 안쓰고 Range 이용했습니다.
                else -> calculate(Operator.create(cur))
            }
        }

        return answer.pop()
    }

    private fun calculate(operator: Operator) = answer.push(
        when (operator) { // 계산부분은 when 식으로 구현해봤습니다.
            Operator.PLUS -> {
                val second = answer.pop()
                val first = answer.pop()
                first + second
            }
            Operator.MINUS -> {
                val second = answer.pop()
                val first = answer.pop()
                first - second
            }
            Operator.MULTIPLE -> {
                val second = answer.pop()
                val first = answer.pop()
                first * second
            }
            Operator.DIVIDE -> {
                val second = answer.pop()
                val first = answer.pop()
                first / second
            }
        }
    )
}

enum class Operator { // 문자 연산자를 열거형 상수로 관리해봤습니다. -> when에서 else식 안쓰려고..

    PLUS, MINUS, MULTIPLE, DIVIDE;

    companion object {
        fun create(operator: Char): Operator = when (operator) {
            '+' -> PLUS
            '-' -> MINUS
            '*' -> MULTIPLE
            else -> DIVIDE // 근데 어짜피 여기서 한 번 써야되서 의미는 없어 보이네요..
        }
    }
}