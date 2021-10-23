package baekjoon.test1023;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1012
문제제목 : 유기농 배추
난이도 : 실버 2
제한사항 : 1초/512MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, DFS, BFS

알고리즘 설명
1. DFS 엔트리포인트 카운트

채점 결과 : 168ms/16132KB
풀이 날짜 : 2021/10/23
*/

public class B1012 {
    static int t, n, m, k;
    static int[][] map;
    static boolean[][] visit;

    static final int[] dr = { 1, -1, 0, 0 };
    static final int[] dc = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            visit = new boolean[n][m];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        visit[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m && map[nextR][nextC] == 1 && !visit[nextR][nextC]) {
                visit[nextR][nextC] = true;
                dfs(nextR, nextC);
            }
        }
    }
}
