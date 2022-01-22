package week1

import java.util.*

/*
플랫폼 : 백준
문제번호 : 10799
문제제목 : 쇠막대기
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 자료구조, 스택

알고리즘 설명
1. 여는 괄호를 만나면 스택에 push
2. 닫는 괄호를 만나면 스택에서 pop -> 닫힌 괄호에 대응하는 여는 괄호 하나를 없애야 되기 때문
3. 닫는 괄호 이전의 괄호(문자열에서 확인)가 열린 괄호이면 레이저이므로 현재 쇠막대 수(스택의 크기)를 누적
4. 닫는 괄호 이전의 괄호(문자열에서 확인)가 닫힌 괄호이면 쇠막대이기 때문에 쇠막대 조각 1 누적

채점 결과 : 204ms/16516KB
풀이 날짜 : 2022/01/22
*/

fun main() {
    val input = readln()
    val stack = Stack<Char>()
    var count = 0

    input.forEachIndexed { i, c ->
        when (c) {
            '(' -> stack.push(c)
            ')' -> {
                stack.pop()
                count += if (input[i-1] == '(') stack.size else 1
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write("$count")
        it.flush()
    }
}