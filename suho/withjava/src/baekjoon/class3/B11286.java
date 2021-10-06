package baekjoon.class3;

import java.io.*;
import java.util.PriorityQueue;

/*
플랫폼 : 백준
문제번호 : 11286
문제제목 : 절댓값 힙
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 우선순위 큐

알고리즘 설명
1. 음수를 담는 최대힙, 양수를 담는 최소힙
2. 각 top을 비교해서 조건에 맞는 수 출력

채점 결과 : 408ms/27108KB
풀이 날짜 : 2021/10/06
*/

public class B11286 {
    static int n;
    static PriorityQueue<Integer> maxHeap, minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                    bw.write("0\n");
                } else if (minHeap.isEmpty()) {
                    bw.write(maxHeap.poll() + "\n");
                } else if (maxHeap.isEmpty()) {
                    bw.write(minHeap.poll() + "\n");
                } else {
                    if (Math.abs(minHeap.peek()) == Math.abs(maxHeap.peek())) {
                        bw.write(maxHeap.poll() + "\n");
                    } else if (Math.abs(minHeap.peek()) < Math.abs(maxHeap.peek())) {
                        bw.write(minHeap.poll() + "\n");
                    } else {
                        bw.write(maxHeap.poll() + "\n");
                    }
                }
            } else if (x > 0) {
                minHeap.add(x);
            } else {
                maxHeap.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
