package baekjoon.test0918;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2573
문제제목 : 빙산
난이도 : 골드 4
제한사항 : 1초/256MB
알고리즘 분류 : 구현, 그래프 이론, 그래프 탐색

알고리즘 설명
1. 1년이라는 시간이 지날 때마다 얼음이 녹음 -> 주변 4방향의 바다 수 만큼
2. 얼음 좌표를 큐에 넣고 주변 바다 수를 세서 녹여준다.
3. 녹아서 0이 된 얼음이 다음 얼음에 영향을 주면 안되기 때문에 방문 배열을 두고 탐색
4. 1년이 끝났으면 빙산이 분리 되었는지 체크
5. 지도에서 얼음이 시작하는 부분에서 DFS를 했을 때, DFS의 엔트리 포인트를 count하면 빙산의 갯수를 알 수 있음
6. 빙산이 2개 이상이 되었으면 더이상 시간을 진행시키지 않고 지난 년수 출력
7. 만약 빙산이 0개(전부 녹았으면)라면 0 출력

채점 결과 : 680ms/155516KB
풀이 날짜 : 2021/09/18
*/

public class B2573 {
    static int n, m;
    static int[][] map;
    static final int[] dr = { -1, 1, 0, 0};
    static final int[] dc = { 0, 0, -1, 1};

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
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int iceCount = countIce();

            if (iceCount == 0) {
                year = 0;
                break;
            } else if (countIce() >= 2) {
                break;
            }

            meltIce();
            year++;
        }

        bw.write(year + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 1년 흐름 -> 큐에 얼음좌표 넣고 주변 바다 수 계산
    static void meltIce() {
        Queue<point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    queue.offer(new point(i, j));
                    visit[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            point cur = queue.poll();

            int sea = 0;

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m && !visit[nextR][nextC] && map[nextR][nextC] == 0) {
                    sea++;
                }
            }

            if (map[cur.r][cur.c] - sea < 0) {
                map[cur.r][cur.c] = 0;
            } else {
                map[cur.r][cur.c] -= sea;
            }
        }
    }

    // 빙하 덩어리 체크 -> dfs 엔트리포인트 세기
    static int countIce() {
        boolean[][] visit = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visit[i][j]) {
                    count++;
                    dfs(i, j, visit);
                }
            }
        }

        return count;
    }

    static void dfs(int r, int c, boolean[][] visit) {
        visit[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m && !visit[nextR][nextC] && map[nextR][nextC] != 0) {
                dfs(nextR, nextC, visit);
            }
        }
    }
}
