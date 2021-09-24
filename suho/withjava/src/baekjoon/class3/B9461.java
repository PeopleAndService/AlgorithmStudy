package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 9461
문제제목 : 파도반 수열
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 수학, DP

알고리즘 설명
1. 점화식 dp[i] = dp[i-2] + dp[i-3]

채점 결과 : 156ms/14568KB
풀이 날짜 : 2021/09/23
*/

public class B9461 {
    static int t;
    static long[] dp;
    static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp = new long[MAX+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= MAX; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
