package baekjoon.class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2178
문제제목 : 미로 탐색
난이도 : 실버 1
제한사항 : 1초/192MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 방문 배열에 거리를 갱신하면서 너비우선탐색
2. 끝점에 도달하면 종료

채점 결과 : 136ms/14732KB
풀이 날짜 : 2021/10/01
*/

public class B2178 {
    static int n, m;
    static int[][] miro, visit;

    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    static class point {
        int r, c;

        public point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(0, 0));
        visit = new int[n][m];
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            point cur = queue.poll();

            if (cur.r == n - 1 && cur.c == m - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m && visit[nextR][nextC] == 0 && miro[nextR][nextC] == 1) {
                    queue.offer(new point(nextR, nextC));
                    visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                }
            }
        }

        bw.write(visit[n-1][m-1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
