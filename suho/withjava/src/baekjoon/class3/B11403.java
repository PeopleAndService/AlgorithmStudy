package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11403
문제제목 : 경로 찾기
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 플로이드-와샬

알고리즘 설명
1. 플로이드 와샬 기본
2. i->j로 가는 경로가 있거나, i->k->j로 가는 경로가 있으면 1로 마킹
3. 인접 그래프 출력

채점 결과 : 308ms/19580KB
풀이 날짜 : 2021/10/04
*/

public class B11403 {
    static int[][] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((graph[i][k] > 0 && graph[k][j] > 0) || graph[i][j] > 0) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(graph[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
