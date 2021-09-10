package programmers.kakaoblind2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KB6 {
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };
    static ArrayList<String> perm;

    static class cursor {
        int r, c, move;

        public cursor(int r, int c, int m) {
            this.r = r;
            this.c = c;
            this.move = m;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    }

    static int solution(int[][] board, int r, int c) {
        perm = new ArrayList<>();
        int cardCount = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    cardCount++;
                }
            }
        }
        cardCount /= 2;
        int[] card = new int[cardCount];
        for (int i = 0; i < cardCount; i++) {
            card[i] = i + 1;
        }
        makePerm("", 0, card);

        int answer = Integer.MAX_VALUE;

        for (String p : perm) {
            String[] order = p.split("");
            int move = 0;

            int[] start = new int[2];
            start[0] = r;
            start[1] = c;

            int[][] temp = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    temp[i][j] = board[i][j];
                }
            }

            for (String o : order) {
                if (move > answer) {
                    break;
                }

                int num = Integer.parseInt(o);

                move += bfs(temp, num, start);
                temp[start[0]][start[1]] = 0;
                move++;

                move += bfs(temp, num, start);
                temp[start[0]][start[1]] = 0;
                move++;
            }

            answer = Math.min(answer, move);
        }

        return answer;
    }

    static void makePerm(String cur, int depth, int[] card) {
        if (depth == card.length) {
            perm.add(cur);
            return;
        }

        for (int i = 0; i < card.length; i++) {
            if (!cur.contains(card[i] + "")) {
                makePerm(cur + card[i], depth + 1, card);
            }
        }
    }

    static int bfs(int[][] board, int target, int[] start) {
        Queue<cursor> queue = new LinkedList<>();
        boolean[][] visit = new boolean[4][4];
        int r = start[0];
        int c = start[1];
        queue.offer(new cursor(r, c, 0));
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            cursor cur = queue.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curMove = cur.move;

            if (board[cur.r][cur.c] == target) {
                start[0] = cur.r;
                start[1] = cur.c;
                return curMove;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (0 <= nextR && nextR < 4 && 0 <= nextC && nextC < 4 && !visit[nextR][nextC]) {
                    visit[nextR][nextC] = true;
                    queue.offer(new cursor(nextR, nextC, curMove + 1));
                }
            }

            for (int i = 0; i < 4; i++) {
                cursor moved = moveCtrl(curR, curC, i, board);
                int nextR = moved.r;
                int nextC = moved.c;

                if (0 <= nextR && nextR < 4 && 0 <= nextC && nextC < 4 && !visit[nextR][nextC]) {
                    visit[nextR][nextC] = true;
                    queue.offer(new cursor(nextR, nextC, curMove + 1));
                }
            }
        }

        return 0;
    }

    static cursor moveCtrl(int r, int c, int d, int[][] board) {
        r += dr[d];
        c += dc[d];

        while (r >= 0 && c >= 0 && r < 4 && c < 4) {
            if (board[r][c] != 0) {
                return new cursor(r, c, 0);
            }
            r += dr[d];
            c += dc[d];
        }

        return new cursor(r - dr[d], c - dc[d], 0);
    }
}
