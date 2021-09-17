package baekjoon.class3;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 11723
문제제목 : 집합
난이도 : 실버 5
제한사항 : 1.5초/4MB(자바 448MB)
알고리즘 분류 : 구현, 비트마스킹

알고리즘 설명
1. 1~20크기의 정수 배열 선언
2. 토글 형식으로 집합에 들어있는지 여부 마스킹

채점 결과 : 1268ms/300460KB
풀이 날짜 : 2021/09/17
*/

public class B11723 {
    static int[] set;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());
        set = new int[21];
        for (int i = 0; i < m; i++) {
            String[] order = br.readLine().split(" ");
            if (order[0].equals("add")) {
                int num = Integer.parseInt(order[1]);
                if (set[num] == 0) {
                    set[num] = 1;
                }
            } else if (order[0].equals("remove")) {
                int num = Integer.parseInt(order[1]);
                if (set[num] == 1) {
                    set[num] = 0;
                }
            } else if (order[0].equals("check")) {
                int num = Integer.parseInt(order[1]);
                if (set[num] == 1) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (order[0].equals("toggle")) {
                int num = Integer.parseInt(order[1]);
                if (set[num] == 1) {
                    set[num] = 0;
                } else {
                    set[num] = 1;
                }
            } else if (order[0].equals("all")) {
                Arrays.fill(set, 1);
            } else {
                Arrays.fill(set, 0);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
