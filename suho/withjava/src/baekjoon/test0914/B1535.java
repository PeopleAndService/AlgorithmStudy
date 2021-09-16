package baekjoon.test0914;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1535
문제제목 : 인녕
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 완전 탐색, 배낭 문제

알고리즘 설명
1. dp[n][health] -> n번까지 인사하고, 남은 체력이 health일 때의 최대 기쁨 저장
2. 배낭 문제와 동일하게 풀이
3. 남은 체력과 현재 사람에게 인사했을 때 소비되는 체력의 합이 100보다 같거나 작고 이전 체력과 소비 체력을 더했을 때의 최대 기쁨이 0이 아니라면
4. n번까지 인사하고, 남은 체력이 health일 때의 최대 기쁨 갱신
5. 무조건 인사하는 것이 아니고 i번째 사람에게 인사를 안하는 경우도 고려하여 갱신

채점 결과 : 132ms/14300KB
풀이 날짜 : 2021/09/16
*/

public class B1535 {
    static int n;
    static int[] health, happy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        health = new int[n+1];
        happy = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[21][101];
        dp[1][100 - health[1]] = happy[1];

        for (int i = 2; i <= n; i++) {
            dp[i][100 - health[i]] = happy[i];
            for (int j = 100; j > 0; j--) {
                if (j + health[i] <= 100 && dp[i-1][j+health[i]] != 0) {
                    dp[i][j] = Math.max(dp[i-1][j+health[i]] + happy[i], dp[i-1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 100; i > 0; i--) {
            answer = Math.max(answer, dp[n][i]);
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
