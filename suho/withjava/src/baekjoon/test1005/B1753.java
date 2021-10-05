package baekjoon.test1005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1753
문제제목 : 최단경로
난이도 : 골드 5
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
다익스트라 기본 문제

채점 결과 : 824ms/109800KB
풀이 날짜 : 2021/10/05
*/

public class B1753 {
    static int v, e, k;
    static ArrayList<edge>[] graph;
    static int[] dist;
    static PriorityQueue<edge> queue;

    static class edge {
        int to, weight;

        public edge(int t, int w) {
            this.to = t;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i]= new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new edge(v, w));
        }

        queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        queue.offer(new edge(k, 0));
        dist[k] = 0;

        while (!queue.isEmpty()) {
            edge cur = queue.poll();

            if (dist[cur.to] < cur.weight) {
                continue;
            }

            for (edge e : graph[cur.to]) {
                int cost = cur.weight + e.weight;
                if (cost < dist[e.to]) {
                    dist[e.to] = cost;
                    queue.offer(new edge(e.to, cost));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (i == k) {
                bw.write(0 + "\n");
                continue;
            }

            if (dist[i] < Integer.MAX_VALUE) {
                bw.write(dist[i] + "\n");
            } else {
                bw.write("INF\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
