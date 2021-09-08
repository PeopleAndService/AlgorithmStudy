package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class P42583 {
    public static void main(String[] args) {

    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();
        int time = 0;
        int curWeight = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        for (int t : truck_weights) {
            truck.offer(t);
        }

        // 1초
        while (!bridge.isEmpty()) {
            curWeight -= bridge.poll();

            if (truck.isEmpty()) {
                time += bridge_length;
                break;
            } else {
                if (curWeight + truck.peek() <= weight) {
                    curWeight += truck.peek();
                    bridge.offer(truck.poll());
                } else {
                    bridge.offer(0);
                }
            }

            time++;
        }

        return time;
    }
}
