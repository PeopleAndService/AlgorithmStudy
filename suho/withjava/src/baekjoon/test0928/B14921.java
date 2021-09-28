package baekjoon.test0928;

import java.io.*;
import java.util.StringTokenizer;

public class B14921 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n - 1;
        long answer = Long.MAX_VALUE;
        while (start < end) {
            long sum = arr[start] + arr[end];
            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
