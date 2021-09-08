package programmers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P42586 {
    public static void main(String[] args) {

    }

    static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> remains = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                remain += 1;
            }
            remains.add(remain);
        }

        for (int i = 0; i < remains.size(); ) {
            int cur = remains.get(i);
            int cnt = 0;
            while (i < remains.size() && remains.get(i) <= cur) {
                cnt++;
                i++;
            }
            queue.offer(cnt);
        }

        int idx = 0;
        int[] answer = new int[queue.size()];
        while (!queue.isEmpty()) {
            answer[idx++] = queue.poll();
        }

        return answer;
    }
}
