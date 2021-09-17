package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1676
문제제목 : 팩토리얼 0의 개수
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 수학

알고리즘 설명
1. 입력받은 숫자를 5로 소인수분해 한 결과가 0의 개수와 같다.

채점 결과 : 128ms/14304KB
풀이 날짜 : 2021/09/17
*/

public class B1676 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
