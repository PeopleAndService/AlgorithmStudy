package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1389
문제제목 : 케빈 베이컨의 6단계 법칙
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS, 플로이드-와샬

알고리즘 설명
1. 플로이드-와샬 알고리즘을 사용하여 각 정점까지의 최단경로 갱신
2. 한 row의 합 구해서 정답 출력

채점 결과 : 136ms/14260KB
풀이 날짜 : 2021/09/27
*/

public class B1389 {
    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    else if (graph[i][k] > 0 && graph[k][j] > 0) {
                        if (graph[i][j] == 0) {
                            graph[i][j] = graph[i][k] + graph[k][j];
                        } else {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }

        int sum = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                temp += graph[i][j];
            }
            if (temp < sum) {
                answer = i;
                sum = temp;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
