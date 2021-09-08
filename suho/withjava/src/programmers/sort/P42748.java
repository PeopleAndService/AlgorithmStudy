package programmers.sort;

import java.util.Arrays;

public class P42748 {
    public static void main(String[] args) {

    }

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] order : commands) {
            int from = order[0];
            int to = order[1];
            int target = order[2];
            int[] temp = new int[to - from + 1];

            for (int i = from - 1, j = 0; i <= to - 1; i++) {
                temp[j++] = array[i];
            }

            Arrays.sort(temp);
            answer[idx++] = temp[target - 1];
        }
        return answer;
    }
}
