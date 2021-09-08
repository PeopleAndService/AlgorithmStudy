package programmers.bruteforce;

import java.util.Arrays;

public class P42840 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
    }

    static int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) {
                score[0]++;
            }
            if (two[i % two.length] == answers[i]) {
                score[1]++;
            }
            if (three[i % three.length] == answers[i]) {
                score[2]++;
            }
        }

        int max = score[0];
        int count = 1;

        for (int i = 1; i < 3; i++) {
            if (max < score[i]) {
                max = score[i];
                count = 1;
            } else if (max == score[i]) {
                count++;
            }
        }

        int[] answer = new int[count];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                answer[idx++] = i + 1;
            }
        }

        return answer;
    }
}
