package programmers.sort;

public class P42747 {
    public static void main(String[] args) {

    }

    static int solution(int[] citations) {
        int start = 0;
        int end = 0;
        for (int n : citations) {
            end = Math.max(end, n);
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 0;

            for (int n : citations) {
                if (mid <= n) {
                    count++;
                }
            }

            if (count < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
