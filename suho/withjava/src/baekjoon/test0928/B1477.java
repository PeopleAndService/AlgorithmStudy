package baekjoon.test0928;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1477
문제제목 : 휴게소 세우기
난이도 : 골드 4
제한사항 : 2초/128MB
알고리즘 분류 : 이분 탐색, 파라메트릭 서치

알고리즘 설명
1. 휴게소 설치 간격을 탐색
2. 시작구간 0과 끝구간 l, 현재 휴게소가 설치된 구간을 일차원 배열에 넣고 정렬
3. mid = 휴게소 설치 간격으로 휴게소를 설치하면 몇 개 더 세울 수 있는지 탐색
4. m보다 크면 오른쪽 구간 탐색
5. m보다 작으면 왼쪽 구간 탐색

채점 결과 : 136ms/14312KB
풀이 날짜 : 2021/09/28
*/

public class B1477 {
    static int n, m, l;
    static ArrayList<Integer> road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        road = new ArrayList<>();
        road.add(0);
        road.add(l);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            road.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(road);
        int start = 0;
        int end = l;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int i = 1; i < road.size(); i++) {
                // 현재 휴게소 구간 사이에 mid 간격으로 몇 개 더 세울 수 있는지 ?
                count += (road.get(i) - road.get(i-1) - 1) / mid;
            }

            if (count > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(start + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
