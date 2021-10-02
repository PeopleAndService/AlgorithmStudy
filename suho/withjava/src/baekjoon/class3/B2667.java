package baekjoon.class3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
플랫폼 : 백준
문제번호 : 2667
문제제목 : 단지번호붙이기
난이도 : 실버 1
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색

알고리즘 설명
1. 건물이 있으면 해당 위치에서 DFS시작, 재귀 호출 횟수 카운트 하면 해당 건물 군집의 수
2. 리스트에 재귀 카운트 넣어주고
3. 방문배열은 하나만 써서 중복 방문 안하도록 구현

채점 결과 : 144ms/14612KB
풀이 날짜 : 2021/10/02
*/

public class B2667 {
    static int n;
    static int[][] map;
    static ArrayList<Integer> counter;
    static int count;

    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        counter = new ArrayList<>();
        count();

        bw.write(counter.size() + "\n");
        Collections.sort(counter);
        for (int c : counter) {
            bw.write(c + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void count() {
        boolean[][] visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    visit[i][j] = true;
                    count = 1;
                    dfs(i, j, visit);
                    counter.add(count);
                }
            }
        }
    }

    static void dfs(int r, int c, boolean[][] visit) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n && map[nextR][nextC] == 1) {
                if (!visit[nextR][nextC]) {
                    visit[nextR][nextC] = true;
                    count++;
                    dfs(nextR, nextC, visit);
                }
            }
        }
    }
}
