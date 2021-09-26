package baekjoon.class3;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 5525
문제제목 : IOI
난이도 : 실버 2
제한사항 : 1초/256MB
알고리즘 분류 : 문자열

알고리즘 설명
1. 메모이제이션으로 접근
2. 문자열에서 나오는 OI의 수를 찾아주고 -> n = i 인 IOI 문자열에서 OI는 i만큼 나오기 때문
3. OI의 수가 n을 넘어갔다면 i-2*n+1번째 문자가 I인지 확인

채점 결과 : 336ms/26032KB
풀이 날짜 : 2021/09/26
*/

public class B5525 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int[] dp = new int[m];
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            if (s[i] == 'O' && s[i+1] == 'I') {
                dp[i+1] = dp[i-1] + 1;
            }

            if (dp[i+1] >= n && s[i-2*n+1] == 'I') {
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
