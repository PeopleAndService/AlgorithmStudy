package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1003
문제제목 : 피보나치 함수
난이도 : 실버 3
제한사항 : 0.25초/128MB
알고리즘 분류 : DP

알고리즘 설명
1. 피보나치 수열을 구하는 것이 아니고 피보나치 함수의 0과 1 재귀호출 횟수를 구하는 것임
2. 피보나치 수열 구하듯이 i-2번째와 i-1번째의 0과 1의 각각의 호출 횟수를 더해주면 된다.

채점 결과 : 148ms/15996KB
풀이 날짜 : 2021/09/20
*/

public class B1003 {
    static int[][] dp;
    static int t, n;
    static final int MAX = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[MAX+1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= MAX; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            bw.write(dp[n][0] + " " + dp[n][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
