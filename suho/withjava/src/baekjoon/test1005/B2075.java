package baekjoon.test1005;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 2075
문제제목 : 자바
난이도 : 골드 5
제한사항 : 1초/12MB
알고리즘 분류 : 자료 구조, 정렬, 우선순위 큐

알고리즘 설명
1. 최소 힙을 사용하면 최소 힙의 top 값은 항상 n번 째 큰 수
2. 최소 힙의 사이즈가 n인 경우 top 값 보다 표의 수가 큰 경우 top을 빼고 넣어준다.
3. 최소 힙의 사이즈가 n보다 작은 경우에는 무조건 add

채점 결과 : 788ms/222672KB
풀이 날짜 : 2021/10/05
*/

public class B2075 {
    static int[][] table;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (minHeap.size() == n) {
                    if (minHeap.peek() < table[i][j]) {
                        minHeap.poll();
                        minHeap.add(table[i][j]);
                    }
                } else if (minHeap.size() < n) {
                    minHeap.add(table[i][j]);
                }
            }
        }

        bw.write(minHeap.poll() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
