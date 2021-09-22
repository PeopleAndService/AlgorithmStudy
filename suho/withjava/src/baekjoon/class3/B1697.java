package baekjoon.class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1697
문제제목 : 숨바꼭질
난이도 : 실버 1
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 1차원 배열을 bfs로 탐색
2. 3가지 경우에 대해 bfs
3. time 배열에 해당위치까지 오는데 걸리는 시간 갱신
4. time 배열에 이미 값이 갱신되어있다면 그 값이 최소값임을 보장하므로 queue에 넣지 않음
5. bfs 중 k점에 도달했으면 중단

채점 결과 : 192ms/18916KB
풀이 날짜 : 2021/09/22
*/

public class B1697 {
    static final int MAX = 100000;
    static int n, k;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            bw.write("0");
        } else {
            time = new int[MAX+1];
            bfs();
            bw.write(time[k] + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = cur - 1;
                } else if (i == 2) {
                    next = cur + 1;
                } else {
                    next = cur * 2;
                }

                if (next == k) {
                    time[next] = time[cur];
                    return;
                }

                if (next >= 0 && next <= MAX && time[next] == 0) {
                    queue.add(next);
                    time[next] = time[cur] + 1;
                }
            }
        }
    }
}
