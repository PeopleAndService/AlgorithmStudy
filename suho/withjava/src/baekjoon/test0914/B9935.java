package baekjoon.test0914;

import java.io.*;
import java.util.Stack;

/*
플랫폼 : 백준
문제번호 : 9935
문제제목 : 문자열 폭발
난이도 : 골드 4
제한사항 : 2초/128MB
알고리즘 분류 : 문자열, 자료 구조, 스택

알고리즘 설명
1. 문자열 돌면서 스택에 한글자씩 push
2. 스택의 마지막 문자열이 폭발 문자열과 같으면 스택에서 pop
3. 마지막 문자까지 넣고 스택을 앞에서 부터 출력하면 폭발 문자열이 폭발한 문자열 완성
4. 빈 스택만 남았을 경우 "FRULA" 출력

채점 결과 : 592ms/32480KB
풀이 날짜 : 2021/09/15
*/

public class B9935 {
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String boom = br.readLine();

        stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            stack.push(cur);

            if (stack.size() >= boom.length()) {
                boolean flag = true;
                for (int j = 0; j < boom.length(); j++) {
                    if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else {
            for (char c : stack) {
                bw.write(c);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
