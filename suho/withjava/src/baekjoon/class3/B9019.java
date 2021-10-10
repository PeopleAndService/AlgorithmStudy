package baekjoon.class3;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 9019
문제제목 : DSLR
난이도 : 골드 5
제한사항 : 6초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색

알고리즘 설명
1. 0부터 9999까지의 각 만들 수 있는 숫자들에 대해 결과가 만들어 졌는지(방문배열)와 해당 숫자의 Command 메모이제이션할 배열 만들어주고
2. BFS로 처음 상태부터 각 명령을 수행했을 때의 숫자에 대해 너비 우선 탐색
3. 큐가 비거나 목표 숫자에 방문했다면 종료
4. 큐에 들어가는 숫자의 방문배열과 Command를 잘 갱신할 것

채점 결과 : 3132ms/315736KB
풀이 날짜 : 2021/10/10
*/

public class B9019 {
    static int t;
    static boolean[] visit;
    static String[] command;

    static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            visit = new boolean[MAX];
            command = new String[MAX];
            Arrays.fill(command, "");

            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            visit[n] = true;

            while (!queue.isEmpty() && !visit[target]) {
                int cur = queue.poll();
                int d = (cur * 2) % MAX;
                int s = (cur == 0) ? 9999 : cur - 1;
                int l = (cur % 1000) * 10 + cur / 1000;
                int r = (cur % 10) * 1000 + cur / 10;

                if (!visit[d]) {
                    visit[d] = true;
                    queue.add(d);
                    command[d] = command[cur] + "D";
                }

                if (!visit[s]) {
                    visit[s] = true;
                    queue.add(s);
                    command[s] = command[cur] + "S";
                }

                if (!visit[l]) {
                    visit[l] = true;
                    queue.add(l);
                    command[l] = command[cur] + "L";
                }

                if (!visit[r]) {
                    visit[r] = true;
                    queue.add(r);
                    command[r] = command[cur] + "R";
                }
            }

            bw.write(command[target] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
