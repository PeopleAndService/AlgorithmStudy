package baekjoon.test0914;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 11058
문제제목 : 크리보드
난이도 : 골드 5
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
1. n = 6까지는 A를 버튼 누른 횟수 만큼 출력하는 것이 최대
2. n = 7부터는 Ctrl ACV, ACVV, ACVVV 중 큰 값이 최대
3. 위 3경우를 확인하기 위해선 각각 3번째 전 인덱스, 4번째 전, 5번째 전의 2, 3, 4배로 확인해야 한다.

채점 결과 : 128ms/14240KB
풀이 날짜 : 2021/09/15
*/

public class B11058 {
    static long[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new long[101];
        for (int i = 0; i <= 6; i++) {
            dp[i] = i;
        }
        for (int i = 7; i <= 100; i++) {
            dp[i] = Math.max(dp[i - 3] * 2, Math.max(dp[i - 4] * 3, dp[i - 5] * 4));
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
