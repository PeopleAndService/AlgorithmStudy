package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 11726
문제제목 : 2xn 타일링
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
1. 타일은 2*1 또는 1*2 크기로만 채울 수 있다.
2. dp[1] = 1, dp[2] = 2, dp[i] = dp[i-1](2*1 타일로 나머지 채움) + dp[i-2](1*2 타일로 나머지 채움)

채점 결과 : 156ms/14336KB
풀이 날짜 : 2021/09/21
*/

public class B11726 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write(1 + "");
        } else if (n == 2) {
            bw.write(2 + "");
        } else {
            dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-2] + dp[i-1]) % 10007;
            }
            bw.write(dp[n] + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
