package baekjoon.test1023;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 14891
문제제목 : 톱니바퀴
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. 각 톱니의 상태를 전부 구해서 돌아가는 방향 또는 돌아가는지 여부를 구해놓고
2. 한번에 회전시켜준다.
3. 톱니의 회전여부는 회전 전에 정해진다.

채점 결과 : 132ms/14368KB
풀이 날짜 : 2021/10/23
*/

public class B14891 {
    static int[][] chains;
    static int k;
    static int[] direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        chains = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                chains[i][j] = input.charAt(j) - '0';
            }
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            direction = new int[4];
            checkChains(idx, dir);
            rotateChains();
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (chains[i][0] == 1) {
                sum += Math.pow(2, i);
            }
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void checkChains(int idx, int dir) {
        direction[idx] = dir;

        int left = idx - 1;
        int right = idx + 1;
        // idx로 2, 6이 맞닿아있음

        if (0 <= left && direction[left] == 0) {
            if (chains[left][2] != chains[idx][6]) {
                checkChains(left, -dir);
            }
        }

        if (right < 4 && direction[right] == 0) {
            if (chains[right][6] != chains[idx][2]) {
                checkChains(right, -dir);
            }
        }
    }

    static void rotateChains() {
        for (int i = 0; i < 4; i++) {
            int[] temp = new int[8];

            if (direction[i] == 1) {
                // 시계방향 -> 인덱스 하나씩 뒤로 밀림
                for (int j = 0; j < 8; j++) {
                    int idx = j + 1;

                    if (idx == 8) {
                        idx = 0;
                    }

                    temp[idx] = chains[i][j];
                }

                chains[i] = temp;
            } else if (direction[i] == -1) {
                // 반시계방향 -> 인덱스 하나씩 앞으로 밀림
                for (int j = 0; j < 8; j++) {
                    int idx = j - 1;

                    if (idx == -1) {
                        idx = 7;
                    }

                    temp[idx] = chains[i][j];
                }

                chains[i] = temp;
            }
        }
    }
}
