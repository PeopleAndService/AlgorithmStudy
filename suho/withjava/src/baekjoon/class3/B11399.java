package baekjoon.class3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 11399
문제제목 : ATM
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 그리디, 정렬

알고리즘 설명
1. 각 사람이 인출하는데 걸리는 시간을 오름차순으로 정렬한다.
2. 그리디한 접근

채점 결과 : 136ms/14568KB
풀이 날짜 : 2021/09/21
*/

public class B11399 {
    static int n;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        time = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int curTime = 0;
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        for (int t : time) {
            curTime += t;
            sum += curTime;
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
