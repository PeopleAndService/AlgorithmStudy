package baekjoon.class3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2606
문제제목 : 바이러스
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색

알고리즘 설명
1. 연결 정보를 인접 그래프로 받고
2. 1번 노드를 출발로 dfs 실행
3. dfs 호출 횟수 카운트

채점 결과 : 144ms/14432KB
풀이 날짜 : 2021/09/20
*/

public class B2606 {
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        count = 0;
        visit = new boolean[n+1];
        visit[1] = true;
        dfs(1);

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur) {
        for (int n : graph[cur]) {
            if (!visit[n]) {
                visit[n] = true;
                count++;
                dfs(n);
            }
        }
    }
}
