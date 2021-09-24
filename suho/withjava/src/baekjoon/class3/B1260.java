package baekjoon.class3;

import java.io.*;
import java.util.*;

/*
플랫폼 : 백준
문제번호 : 1260
문제제목 : DFS와 BFS
난이도 : 실버 2
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색

알고리즘 설명
DFS와 BFS 기본 구현

채점 결과 : 296ms/19960KB
풀이 날짜 : 2021/09/24
*/

public class B1260 {
    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        visit = new boolean[n+1];
        visit[v] = true;
        dfs(v);
        bw.newLine();
        bfs();
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur) throws IOException {
        bw.write(cur + " ");

        for (int node : graph[cur]) {
            if (!visit[node]) {
                visit[node] = true;
                dfs(node);
            }
        }
    }

    static void bfs() throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        visit = new boolean[n+1];
        visit[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            bw.write(cur + " ");

            for (int node : graph[cur]) {
                if (!visit[node]) {
                    visit[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
