package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1780
문제제목 : 종이의 개수
난이도 : 실버 2
제한사항 : 2초/256MB
알고리즘 분류 : 분할 정복, 재귀

알고리즘 설명
1. 분할 정복 -> step(초기값은 n) / 3 씩 뛰면서 재귀로 푼다.
2. 재귀 -> step == 1이거나, 색종이가 다 같은색이면 종료
백준 2630 색종이 만들기와 비슷한 문제

채점 결과 : 952ms/312220KB
풀이 날짜 : 2021/09/25
*/

public class B1780 {
    static int[][] paper;
    static int n;
    static int minusOne, zero, plusOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        paper = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minusOne = 0;
        zero = 0;
        plusOne = 0;
        dfs(0, 0, n);
        bw.write(minusOne + "\n" + zero + "\n" + plusOne);
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check(int r, int c, int step) {
        int num = paper[r][c];
        for (int i = r; i < r + step; i++) {
            for (int j = c; j < c + step; j++) {
                if (paper[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs(int r, int c, int step) {
        if (step == 1) {
            if (paper[r][c] == -1) {
                minusOne++;
            } else if (paper[r][c] == 0) {
                zero++;
            } else {
                plusOne++;
            }
            return;
        }

        if (check(r, c, step)) {
            if (paper[r][c] == -1) {
                minusOne++;
            } else if (paper[r][c] == 0) {
                zero++;
            } else {
                plusOne++;
            }
            return;
        }

        for (int i = r; i < r + step; i += step / 3) {
            for (int j = c; j < c + step; j += step / 3) {
                dfs(i, j, step / 3);
            }
        }
    }
}
