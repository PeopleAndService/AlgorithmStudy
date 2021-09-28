package baekjoon.test0928;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2610
문제제목 : 회의준비
난이도 : 골드 2
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 플로이드-와샬

알고리즘 설명
1. 플로이드-와샬로 모든 쌍 최단경로를 구하면 모든 참석자들의 의사전달시간이 구해짐
2. 방문배열을 하나 두고 위원회의 각 구성원중 최대값이 최소가 되는 대표를 찾아주고 리스트에 넣는다. (findMax, findMin 함수 참고)
3. 정답 리스트의 크기가 위원회의 수 K, 이를 오름차순으로 정렬하고 출력하면 각 대표

채점 결과 : 244ms/15800KB
풀이 날짜 : 2021/09/28
*/

public class B2610 {
    static int[][] graph;
    static int n, m;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
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

        visit = new boolean[n+1];
        ArrayList<Integer> council = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                council.add(findMin(i));
            }
        }
        bw.write(council.size() + "\n");
        Collections.sort(council);
        for (int c : council) {
            bw.write(c + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int findMin(int num) {
        visit[num] = true;
        int idx = num;
        int result = findMax(num);
        for (int i = 1; i <= n; i++) {
            if (!visit[i] && graph[num][i] > 0) {
                visit[i] = true;
                int temp = findMax(i);
                if (temp < result) {
                    idx = i;
                    result = temp;
                }
            }
        }
        return idx;
    }

    static int findMax(int num) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (graph[num][i] > 0) {
                result = Math.max(result, graph[num][i]);
            }
        }
        return result;
    }
}
