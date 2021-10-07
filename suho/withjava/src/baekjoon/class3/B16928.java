package baekjoon.class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 16928
문제제목 : 뱀과 사다리 게임
난이도 : 실버 1
제한사항 : 80ms/11772KB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비우선탐색

알고리즘 설명
1. BFS로 돈다
2. 1차원 배열이라 생각하고 인덱스를 각 칸이라고 여김
3. 사다리와 뱀 정보를 입력받는다. (0이면 뱀, 사다리 칸 아님, 0 아니면 뱀, 사다리 있어서 이동함)
4. 첫번쨰 칸부터 bfs 시작

채점 결과 : 80ms/11772KB
풀이 날짜 : 2021/10/07
*/

public class B16928 {
    static int n, m;
    static int[] board;
    static int[] count;
    static boolean[] visit;
    static final int END = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[END +1];
        count = new int[END +1];
        visit = new boolean[END +1];
        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        count[1] = 0;
        visit[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == END) {
                break;
            }

            for (int i = 1; i < 7; i++) {
                int next = cur + i;
                if (next <= END && !visit[next]) {
                    visit[next] = true;
                    if (board[next] != 0) {
                        if (!visit[board[next]]) {
                            queue.offer(board[next]);
                            visit[board[next]] = true;
                            count[board[next]] = count[cur] + 1;
                        }
                    } else {
                        queue.offer(next);
                        count[next] = count[cur] + 1;
                    }
                }
            }
        }

        bw.write(count[END] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
