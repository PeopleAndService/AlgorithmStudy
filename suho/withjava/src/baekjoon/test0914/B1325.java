package baekjoon.test0914;

import java.io.*;
import java.util.*;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1325번
 * 문제제목 : 효율적인 해킹
 * 난이도 : 실버 2
 * 제한사항 : 5초/256MB
 * 알고리즘 분류 : 그래프 이론, 그래프 탐색
 *
 * 알고리즘 설명
 * 1. 해킹할 수 있는 컴퓨터간의 신뢰하는 관계를 인접 그래프로 나타냄
 * 2. dfs(또는 bfs)를 돌면서 노드 방문 횟수를 count -> answer 배열의 값 증가
 * 3. dfs를 돌면서 방문하는 노드가 곧 함께 해킹할 수 있는 컴퓨터이기 때문
 * 4. answer 배열에서 max값을 찾고 max값과 같은 컴퓨터 번호 출력
 * 자바로 하면 dfs와 bfs 모두 시간초과. 동일 코드로 pypy3에서 시간초과 안남
 *
 * 채점 결과 : -
 * 풀이 날짜 : 2021/09/15
**/

public class B1325 {
    static int[] answer;
    static boolean[] visit;
    static ArrayList<Integer>[] computer;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        computer = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            computer[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computer[b].add(a);
        }
        int max = 0;
        answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n+1];
            visit[i] = true;
            dfs(i, i);
            if (answer[i] > max) {
                max = answer[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (answer[i] == max) {
                sb.append(i + " ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int cur) {
        for (int n : computer[cur]) {
            if (!visit[n]) {
                visit[n] = true;
                answer[start]++;
                dfs(start, n);
            }
        }
    }
}
