package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 17626
문제제목 : Four Squares
난이도 : 실버 4
제한사항 : 0.5초/512MB
알고리즘 분류 : DP, 완전 탐색

알고리즘 설명
1. 1부터 차례대로 제곱수의 최소 개수를 dp에 저장 (바텀업)
2. i의 dp값은 i보다 작은 모든 제곱수들 중 i - 제곱수를 한 해중 가장 작은 해에 1을 더한 값
3. 그리디로 풀 수 없다.

채점 결과 : 160ms/15424KB
풀이 날짜 : 2021/09/19
*/

public class B17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        int min;
        for (int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i-j*j]);
            }

            dp[i] = min + 1;
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
