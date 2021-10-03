package baekjoon.class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 7569
문제제목 : 토마토
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 3차원 그래프 탐색 -> 방향은 동서남북상하 6가지
2. BFS로만 탐색 가능
3. 초기에 익은 토마토가 있는 곳과 토마토가 없는 곳은 방문배열 true로 초기화
4. 익은 토마토는 큐에 넣고 BFS 시작
5. 1년이 흐를 때 주변이 익으므로 현재 queue 크기만큼의 토마토 탐색해야 정확한 결과가 나온다.

채점 결과 : 724ms/122824KB
풀이 날짜 : 2021/10/03
*/

public class B7569 {
    static int m, n, h;
    static int[][][] store;
    static boolean[][][] visit;

    static final int[] dr = { -1, 1, 0, 0, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1, 0, 0 };
    static final int[] dh = { 0, 0, 0, 0, -1, 1 };

    static class point {
        int r, c, h;

        public point(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        store = new int[n][m][h];
        visit = new boolean[n][m][h];
        Queue<point> queue = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    store[i][j][k] = Integer.parseInt(st.nextToken());
                    if (store[i][j][k] == 1) {
                        visit[i][j][k] = true;
                        queue.offer(new point(i, j, k));
                    } else if (store[i][j][k] == -1){
                        visit[i][j][k] = true;
                    }
                }
            }
        }
        int answer = -1;
        while (!queue.isEmpty()) {
            int tomatoCnt = queue.size();
            answer++;
            while (tomatoCnt-- > 0) {
                point cur = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];
                    int nextH = cur.h + dh[i];

                    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m && 0 <= nextH && nextH < h) {
                        if (!visit[nextR][nextC][nextH] && store[nextR][nextC][nextH] == 0) {
                            visit[nextR][nextC][nextH] = true;
                            queue.offer(new point(nextR, nextC, nextH));
                        }
                    }
                }
            }
        }
        boolean flag = true;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j][k]) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (flag) {
            bw.write(answer + "");
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
