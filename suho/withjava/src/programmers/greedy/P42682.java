package programmers.greedy;

import java.util.Arrays;

public class P42682 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }

    static int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        Arrays.fill(student, 1);

        for (int l : lost) {
            student[l-1]--;
        }

        for (int r : reserve) {
            student[r-1]++;
        }

        for (int i = 0; i < n; i++) {
            if (student[i] == 2) {
                if (i != 0 && student[i-1] == 0) {
                    student[i-1]++;
                } else if (i != n - 1 && student[i+1] == 0) {
                    student[i+1]++;
                }
                student[i]--;
            }
        }

        return Arrays.stream(student).sum();
    }
}
