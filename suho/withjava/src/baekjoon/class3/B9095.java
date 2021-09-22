package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 9095
문제제목 : 1, 2, 3 더하기
난이도 : 실버 3
제한사항 : 1, 2, 3 더하기
알고리즘 분류 : DP

알고리즘 설명
1. 1, 2, 3만 더할 수 있으므로 1, 2, 3을 만드는 경우의 수는 초기화 시켜놔야한다. (1, 2, 4)
2. i(i >=4)를 만드는 경우의 수는 dp[i-1] + dp[i-2] + dp[i-3]

채점 결과 : 140ms/14512KB
풀이 날짜 : 2021/09/20
*/

public class B9095 {
    static int t, n;
    static final int MAX = 10;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[MAX + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= MAX; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
