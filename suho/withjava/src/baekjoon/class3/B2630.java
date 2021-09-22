package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2630
문제제목 : 색종이 만들기
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 분할 정복, 재귀

알고리즘 설명
1. 재귀로 푼다. -> step이 1이거나 색종이가 다 같은 색이면 종료
2. step을 /2 해가면서 분할 정복

채점 결과 : 236ms/17400KB
풀이 날짜 : 2021/09/20
*/

public class B2630 {
    static int[][] paper;
    static int n;
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0;
        blue = 0;
        dfs(0, 0, n);

        bw.write(white + "\n" + blue);
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isAllSameColor(int r, int c, int step) {
        int color = paper[r][c];
        for (int i = r; i < r + step; i++) {
            for (int j = c; j < c + step; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs(int r, int c, int step) {
        if (step == 1) {
            if (paper[r][c] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        if (isAllSameColor(r, c, step)) {
            if (paper[r][c] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        for (int i = r; i < r + step; i += step / 2) {
            for (int j = c; j < c + step; j += step / 2) {
                dfs(i, j, step / 2);
            }
        }
    }
}
