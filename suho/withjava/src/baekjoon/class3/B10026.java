package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 10026
문제제목 : 적록색약
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS, DFS

알고리즘 설명
1. DFS + 시뮬레이션
2. 조건에 맞는 DFS로 분기
3. DFS 엔트리 포인트 카운트

채점 결과 : 168ms/16356KB
풀이 날짜 : 2021/10/11
*/

public class B10026 {
    static int n;
    static int rbCnt, rgbCnt;
    static char[][] graph;
    static boolean[][] visit;

    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    rbCnt++;
                    if (graph[i][j] == 'B') {
                        bDFS(i, j);
                    } else {
                        rDFS(i, j);
                    }
                }
            }
        }

        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    rgbCnt++;
                    if (graph[i][j] == 'R') {
                        normalRDFS(i, j);
                    } else if (graph[i][j] == 'G') {
                        gDFS(i, j);
                    } else {
                        bDFS(i, j);
                    }
                }
            }
        }

        bw.write(rgbCnt + " " + rbCnt);
        bw.flush();
        bw.close();
        br.close();
    }

    // 적녹색약용
    static void rDFS(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                if (!visit[nextR][nextC] && (graph[nextR][nextC] == 'R' || graph[nextR][nextC] == 'G')) {
                    visit[nextR][nextC] = true;
                    rDFS(nextR, nextC);
                }
            }
        }
    }

    // 일반사람용
    static void gDFS(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                if (!visit[nextR][nextC] && graph[nextR][nextC] == 'G') {
                    visit[nextR][nextC] = true;
                    gDFS(nextR, nextC);
                }
            }
        }
    }

    static void normalRDFS(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                if (!visit[nextR][nextC] && graph[nextR][nextC] == 'R') {
                    visit[nextR][nextC] = true;
                    normalRDFS(nextR, nextC);
                }
            }
        }
    }

    // 파랑색용
    static void bDFS(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n) {
                if (!visit[nextR][nextC] && graph[nextR][nextC] == 'B') {
                    visit[nextR][nextC] = true;
                    bDFS(nextR, nextC);
                }
            }
        }
    }
}
