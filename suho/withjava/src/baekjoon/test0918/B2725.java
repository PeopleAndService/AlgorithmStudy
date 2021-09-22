package baekjoon.test0918;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2725
문제제목 : 보이는 점의 개수
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 정수론, 누적합, 유클리드 호제법

알고리즘 설명
1. 같은 기울기 상의 점에서 좌표 x, y의 최대공약수가 1이면 보이는 점
2. 사각형 좌표의 절반 범위에 대해서 누적합 수행
3. 절반 범위에 대해서 구한 것이므로 *2 해주고 (1, 1) 중복 계산 빼주면 정답

채점 결과 : 212ms/14812KB
풀이 날짜 : 2021/09/18
*/

public class B2725 {
    static int c;
    static int[] dp;
    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[MAX+1];
        dp[0] = 0;
        dp[1] = 2;
        for (int i = 2; i <= MAX; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (gcd(i, j) == 1) {
                    count++;
                }
            }
            dp[i] = dp[i-1] + count;
        }

        c = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < c; tc++) {
            int n = Integer.parseInt(br.readLine());
            bw.write((dp[n] * 2 - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}
