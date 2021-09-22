package baekjoon.class3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11724
문제제목 : 연결 요소의 개수
난이도 : 실버 2
제한사항 : 3초/512MB
알고리즘 분류 : 그래프 이론, 그래프 탐색

알고리즘 설명
1. dfs 엔트리 포인트 찾기

채점 결과 : 692ms/141104KB
풀이 날짜 : 2021/09/22
*/

public class B11724 {
    static int n, m;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        int answer = count();
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int count() {
        boolean[] visit = new boolean[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                count++;
                dfs(i, visit);
            }
        }
        return count;
    }

    static void dfs(int cur, boolean[] visit) {
        visit[cur] = true;

        for (int n : tree[cur]) {
            if (!visit[n]) {
                dfs(n, visit);
            }
        }
    }
}
