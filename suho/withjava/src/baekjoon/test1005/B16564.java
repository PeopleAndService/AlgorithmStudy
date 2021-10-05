package baekjoon.test1005;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 16564
문제제목 : 히오스 프로게이머
난이도 : 실버 1
제한사항 : 2초/512MB
알고리즘 분류 : 이분 탐색

알고리즘 설명
1. 최소 레벨을 mid로 잡았을 때 필요한 레벨 증가값으로 이분탐색
2. 최소 레벨의 범위는 현재 레벨의 최소부터 최대 + 10까지
3. mid를 구하면 레벨의 최소값을 mid로 전부 맞추는데 필요한 count 셈
4. count가 k보다 작거나 같은경우 우측 범위로 탐색 범위 한정, mid값으로 정답 갱신
5. count가 k보다 큰 경우 왼쪽 범위로 탐색 범위 한정

채점 결과 : 440ms/29448KB
풀이 날짜 : 2021/10/05
*/

public class B16564 {
    static int n, k;
    static int[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(level);
        int start = level[0];
        int end = level[n-1] + k;
        long answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long temp = 0;
            for (int l : level) {
                if (l < mid) {
                    temp += mid - l;
                }
            }

            if (temp <= k) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
