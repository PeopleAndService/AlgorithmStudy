package baekjoon.test0918;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 3020
문제제목 : 개똥벌레
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 이분 탐색, 누적합

알고리즘 설명
1. 석순과 종유석이 시작하는 위치와 끝나는 위치에 +1, -1씩 증감
2. 높이의 각 구간을 일차원 배열로 하는 배열에 증감시킨 결과를 누적합
3. 해당 구간의 누적합이 장애물의 갯수
4. 최솟값을 구하고 같은 구간의 갯수 세준다.

채점 결과 : 332ms/29296KB
풀이 날짜 : 2021/09/18
*/

public class B3020 {
    static int n, h;
    static int[] gull;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 첫 장애물 석순, 그 다음 종유석 -> 번갈아가면서
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        gull = new int[h];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            // 석순
            if (i % 2 == 0) {
                // 아래서부터
                gull[0]++;
                if (input != h) {
                    gull[input]--;
                }
            } else {
                // 종유석 -> 위에서부터
                int endIdx = h - input;
                if (endIdx >= 0) {
                    gull[endIdx]++;
                }
            }
        }

        int result = gull[0];
        int count = 1;

        for (int i = 1; i < h; i++) {
            gull[i] = gull[i-1] + gull[i];
            if (gull[i] < result) {
                count = 1;
                result = gull[i];
            } else if (gull[i] == result) {
                count++;
            }
        }

        bw.write(result + " " + count);
        bw.flush();
        bw.close();
        br.close();
    }
}
