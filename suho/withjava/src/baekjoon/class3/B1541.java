package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1541
문제제목 : 잃어버린 괄호
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 수학, 문자열, 그리디, 파싱

알고리즘 설명
1. 그리디한 접근으로, 뺄셈으로 식을 분리하여 괄호를 치면 최솟값을 만들 수 있다.
2. 입력받은 식을 뺄셈으로 split
3. 분리된 덧셈식을 계산하여 계속 빼준다.

채점 결과 : 136ms/14300KB
풀이 날짜 : 2021/09/24
*/

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("-");

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            int temp = 0;
            String[] expression = input[i].split("\\+");

            for (String n : expression) {
                temp += Integer.parseInt(n);
            }

            if (answer == Integer.MAX_VALUE) {
                answer = temp;
            } else {
                answer -= temp;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
