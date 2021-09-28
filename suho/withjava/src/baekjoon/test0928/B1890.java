package baekjoon.test0928;

import java.io.*;
import java.util.StringTokenizer;

public class B1890 {
    static int[][] pane;
    static int n;
    static long[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        pane = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pane[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new long[n][n];
        answer[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) continue;
                int nextR = i + pane[i][j];
                int nextC = j + pane[i][j];

                if (0 <= nextR && nextR < n) {
                    answer[nextR][j] += answer[i][j];
                }

                if (0 <= nextC && nextC < n) {
                    answer[i][nextC] += answer[i][j];
                }
            }
        }
        bw.write(answer[n-1][n-1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
