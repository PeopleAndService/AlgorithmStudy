package programmers.bruteforce;

import java.util.HashSet;

public class P42839 {
    static final int MAX = 10000000;
    static HashSet<Integer> permutation;
    static boolean[] visit;

    public static void main(String[] args) {

    }

    static int solution(String numbers) {
        boolean[] prime = new boolean[MAX];

        for (int i = 2; i <= Math.sqrt(MAX) + 1; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < MAX; j += i) {
                    prime[j] = true;
                }
            }
        }

        visit = new boolean[numbers.length()];
        permutation = new HashSet<>();

        makePerm("", numbers, 0);

        int count = 0;
        for (int n : permutation) {
            if (!prime[n] && n >= 2) {
                count++;
            }
        }

        return count;
    }

    static void makePerm(String cur, String str, int depth) {
        if (depth > 0) {
            permutation.add(Integer.parseInt(cur));
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visit[i]) {
                if (depth == 0 && str.charAt(i) == '0') {
                    continue;
                }
                visit[i] = true;
                makePerm(cur + str.charAt(i), str, depth + 1);
                visit[i] = false;
            }
        }
    }
}
