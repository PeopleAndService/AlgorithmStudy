package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 1992
문제제목 : 쿼드트리
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 분할 정복, 재귀

알고리즘 설명
1. 4분할 분할 정복 문제
2. 분할 정복 시작과 끝에서 괄호를 넣어주면 된다.

채점 결과 : 128ms/14264KB
풀이 날짜 : 2021/09/30
*/

public class B1992 {
    static int[][] image;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        image = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                image[i][j] = input.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();
        dfs(0, 0, n);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int step) {
        if (check(r, c, step)) {
            sb.append(image[r][c]);
            return;
        }

        int nextStep = step / 2;

        sb.append("(");

        dfs(r, c, nextStep);
        dfs(r, c + nextStep, nextStep);
        dfs(r + nextStep, c, nextStep);
        dfs(r + nextStep, c + nextStep, nextStep);

        sb.append(")");
    }

    static boolean check(int r, int c, int step) {
        int color = image[r][c];

        for (int i = r; i < r + step; i++) {
            for (int j = c; j < c + step; j++) {
                if (color != image[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
