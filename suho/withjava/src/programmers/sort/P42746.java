package programmers.sort;

import java.util.PriorityQueue;

public class P42746 {
    public static void main(String[] args) {

    }

    static String solution(int[] numbers) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));

        String answer = "";

        for (int n : numbers) {
            queue.offer(String.valueOf(n));
        }

        while (!queue.isEmpty()) {
            answer += queue.poll();
        }

        int count = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '0') {
                count++;
            }
        }

        if (count == answer.length()) {
            return "0";
        }

        return answer;
    }
}
