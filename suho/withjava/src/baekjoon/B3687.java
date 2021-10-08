package baekjoon;

import java.io.*;
import java.util.Arrays;

/*
플랫폼 : 백준
문제번호 : 3687
문제제목 : 성냥개비
난이도 : 골드 2
제한사항 : 1초/128MB
알고리즘 분류 : DP, 그리디

알고리즘 설명
1. 최소 숫자의 경우, 성냥개비수로 만들 수 있는 최소 숫자를 dp로 푼다.
2. 0~9의 숫자를 만드는 데 필요한 성냥개비수를 구한다음 dp 배열을 초기화한다.
3. 6의 경우 0을 만들 수 있지만 0은 맨 앞자리에 나오면 안되므로 6이 최소 숫자가 된다. -> 같은 의미로 8개의 성냥개비로 만드는 최소 숫자가 10이 된다.
4. 9부터 100까지 최소 숫자를 구한다.
5. 최대 숫자의 경우 짝수이면 1, 홀수이면 앞이 7이고 뒤가 전부 1이게 된다.

채점 결과 : 184ms/16444KB
풀이 날짜 : 2021/10/08
*/

public class B3687 {
    static int t, n;
    static long[] minNum;
    static String[] maxNum;
    static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        minNum = new long[MAX+1];
        maxNum = new String[MAX+1];

        Arrays.fill(minNum, Long.MAX_VALUE);
        minNum[2] = 1;
        minNum[3] = 7;
        minNum[4] = 4;
        minNum[5] = 2;
        minNum[6] = 6;
        minNum[7] = 8;
        minNum[8] = 10;

        String[] min = { "1", "7", "4", "2", "0", "8" };

        for (int i = 9; i <= MAX; i++) {
            for (int j = 2; j <= 7; j++) {
                String temp = minNum[i-j] + min[j-2];
                minNum[i] = Math.min(minNum[i], Long.parseLong(temp));
            }
        }

        maxNum[2] = "1";
        for (int i = 3; i <= MAX; i++) {
            String temp = "";
            if (i % 2 == 0) {
                for (int j = 0; j < i / 2; j++) {
                    temp += "1";
                }
            } else {
                temp += "7";
                for (int j = 0; j < i / 2 - 1; j++) {
                    temp += "1";
                }
            }
            maxNum[i] = temp;
        }

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            bw.write(minNum[n] + " " + maxNum[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
