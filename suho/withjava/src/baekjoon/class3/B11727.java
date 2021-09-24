package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 11727
문제제목 : 2xn 타일링 2
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 다이나믹 프로그래밍

알고리즘 설명
1. 타일은 1*2, 2*1, 2*2 가 있다.
2. i번째에서 타일을 채우는 경우의 수 : i-1까지 채우고 2*1타일 사용하거나 i-2까지 채우고 1*2 2장, 2*2 한장을 놓는 두 경우가 있다.
3. dp[i] = dp[i-1] + dp[i-2] * 2

채점 결과 : 132ms/14324KB
풀이 날짜 : 2021/09/23
*/

public class B11727 {
    static int n;
    static int[] dp;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write(1 + "");
        } else if (n == 2) {
            bw.write(3 + "");
        } else {
            dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3; i <= n; i++) {
                dp[i]= (dp[i-1] + dp[i-2] * 2) % MOD;
            }
            bw.write(dp[n] + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
