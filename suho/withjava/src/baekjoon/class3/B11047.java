package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11047
문제제목 : 동전 0
난이도 : 실버 2
제한사항 : 1초/256MB
알고리즘 분류 : 그리디

알고리즘 설명
1. 큰 동전부터 몫을 계산해서 더해주고
2. k를 동전으로 나눈 나머지로 갱신한다.

채점 결과 : 136ms/14268KB
풀이 날짜 : 2021/09/25
*/

public class B11047 {
    static int n, k;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k >= 0) {
                count += k / money[i];
                k %= money[i];
            } else {
                break;
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
