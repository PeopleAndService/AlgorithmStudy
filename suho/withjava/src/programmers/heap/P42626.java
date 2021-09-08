package programmers.heap;

import java.util.PriorityQueue;

public class P42626 {
    public static void main(String[] args) {

    }

    static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int s : scoville) {
            minHeap.offer(s);
        }

        while (!minHeap.isEmpty()) {
            int first = minHeap.poll();
            if (first >= K) {
                return count;
            }
            if (minHeap.isEmpty()) {
                return -1;
            }
            int second = minHeap.poll();
            int newS = first + (second * 2);
            minHeap.offer(newS);
            count++;
        }

        return -1;
    }
}
