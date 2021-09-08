package programmers.heap;

import java.util.PriorityQueue;

public class P42627 {
    public static void main(String[] args) {

    }

    static int solution(int[][] jobs) {
        PriorityQueue<job> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.length == o2.length) {
                return o1.inTime - o2.inTime;
            }
            return o1.length - o2.length;
        });

        int inTime = -1;
        int sum = 0;
        int count = 0;
        int time = 0;

        while (count < jobs.length) {
            for (int[] j : jobs) {
                if (inTime < j[0] && j[0] <= time) {
                    minHeap.offer(new job(j[0], j[1]));
                }
            }
            if (!minHeap.isEmpty()) {
                job cur = minHeap.poll();
                inTime = time;
                time += cur.length;
                sum += (time - cur.inTime);
                count++;
            } else {
                time++;
            }
        }

        return sum / jobs.length;
    }

    static class job {
        int inTime, length;

        public job(int i, int l) {
            this.inTime = i;
            this.length = l;
        }
    }
}
