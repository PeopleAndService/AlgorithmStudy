package baekjoon.test1005;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1654
문제제목 : 랜선 자르기
난이도 : 실버 3
제한사항 : 2초/128MB
알고리즘 분류 : 이분 탐색, 매개 변수 탐색

알고리즘 설명
1. 랜선을 mid 길이로 잘랐을 때 나오는 랜선의 수의 총합을 매개로 이분 탐색
2. 랜선을 자를 수 있는 단위는 1 ~ 랜선의 최대 길이
3. 자른 후의 랜선 수의 총합은 count += 길이 / mid
4. 랜선 수가 n보다 크거나 같으면 우측 범위 탐색
5. 랜선 수가 n보다 작으면 왼쪽 범위 탐색
6. n개보다 많이 만드는 경우도 n개를 만드는 것에 포함되고 랜선을 자르는 최대 길이를 구해야하므로 end가 정답

채점 결과 : 208ms/17780KB
풀이 날짜 : 2021/10/05
*/

public class B1654 {
    static int k, n;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        line = new int[k];
        for (int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(line);
        long start = 1;
        long end = line[k-1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int l : line) {
                count += l / mid;
            }

            if (count >= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(end + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
