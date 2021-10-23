package baekjoon.test1023;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2352
문제제목 : 반도체 설계
난이도 : 골드 2
제한사항 : 2초/128MB
알고리즘 분류 : 이분 탐색, 가장 긴 증가하는 부분 수열

알고리즘 설명
LIS 알고리즘 사용

채점 결과 : 3488ms/22208KB
풀이 날짜 : 2021/10/23
*/

public class B2352 {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        Arrays.fill(dp, 1);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
