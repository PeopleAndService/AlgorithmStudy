package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 14500
문제제목 : 테트로미노
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 브루트포스 알고리즘

알고리즘 설명
1. ㅜ 모양을 제외하면 나머지는 깊이가 4인 DFS를 하면서 길이가 4일때 정답 갱신해주면 된다.
2. ㅜ 모양의 탐색 경로는 따로 저장
3. 나머지 모양에 대해 깊이 4의 재귀 DFS 수행
4. 백트래킹 수행을 위해 방문배열 조작 필요
5. ㅜ 모양의 회전 포함 최대값 체크
6. 갱신된 정답 출력

채점 결과 : 712ms/35684KB
풀이 날짜 : 2021/10/16
*/

public class B14500 {
    static int n, m, answer;
    static int[][] map;
    static boolean[][] visit;

    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    static final int[][] wooR = { { 0, 0, 0, 1 }, { 0, 1, 2, 1 }, { 0, 0, 0, -1 }, { 0, -1, 0, 1} };
    static final int[][] wooC = { { 0, 1, 2, 1 }, { 0, 0, 0, 1 }, { 0, 1, 2, 1 }, { 0, 1, 1, 1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visit[i][j] = false;
                checkWooShape(i, j);
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int sum, int depth) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m) {
                if (!visit[nextR][nextC]) {
                    visit[nextR][nextC] = true;
                    dfs(nextR, nextC, sum + map[nextR][nextC], depth + 1);
                    visit[nextR][nextC] = false;
                }
            }
        }
    }

    static void checkWooShape(int r, int c) {
        for (int i = 0; i < 4; i++) {
            boolean flag = false;
            int temp = 0;

            for (int j = 0; j < 4; j++) {
                int nextR = r + wooR[i][j];
                int nextC = c + wooC[i][j];

                if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m) {
                    temp += map[nextR][nextC];
                } else {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer = Math.max(answer, temp);
            }
        }
    }
}
