package baekjoon.test0918;

import java.io.*;
import java.util.Stack;

/*
플랫폼 : 백준
문제번호 : 4949
문제제목 : 균형잡힌 세상
난이도 : 실버 4
제한사항 : 1초/128MB
알고리즘 분류 : 문자열, 스택

알고리즘 설명
1. 스택으로 판별하는 올바른 괄호 문자열 문제

채점 결과 : 240ms/19172KB
풀이 날짜 : 2021/09/18
*/

public class B4949 {
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            stack = new Stack<>();

            boolean flag = true;
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);

                if (cur == '(' || cur == '[') {
                    stack.push(cur);
                } else if (cur == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (cur == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!flag || !stack.isEmpty()) {
                bw.write("no\n");
            } else {
                bw.write("yes\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
