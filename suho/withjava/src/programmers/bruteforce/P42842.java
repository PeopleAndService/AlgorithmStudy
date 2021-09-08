package programmers.bruteforce;

public class P42842 {
    public static void main(String[] args) {

    }

    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            int x = yellow % i;
            if (x == 0) {
                int y = yellow / i;

                if ((i + 2) * (y + 2) == brown + yellow) {
                    answer[0] = Math.max(i, y) + 2;
                    answer[1] = Math.min(i, y) + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
