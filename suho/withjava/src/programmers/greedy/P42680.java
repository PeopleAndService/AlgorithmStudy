package programmers.greedy;

import java.util.ArrayList;

public class P42680 {
    static final int[] dist = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3 ,2, 1};

    public static void main(String[] args) {
        System.out.println(solution("ABAAAAAAAAABB"));
    }

    static int solution(String name) {
        ArrayList<Integer> check = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < name.length(); i++) {
            int cur = name.charAt(i) - 'A';
            if (cur != 0) {
                check.add(i);
                count += dist[cur];
            }
        }

        int cursor = 0;

        while (!check.isEmpty()) {
            int idx = 0;
            int target = check.get(0);
            int move = Math.min(Math.abs(target - cursor), name.length() - (Math.abs(target - cursor)));
            for (int i = 1; i < check.size(); i++) {
                int cur = check.get(i);
                int gap = Math.min(Math.abs(cursor - cur), name.length() - (Math.abs(cursor - cur)));
                if (move > gap) {
                    move = gap;
                    target = cur;
                    idx = i;
                }
            }
            count += move;
            cursor = target;
            check.remove(idx);
        }

        return count;
    }
}
