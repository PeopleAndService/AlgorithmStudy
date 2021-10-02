package baekjoon.test0928;

import java.io.*;

/*
플랫폼 : 백준
문제번호 : 2469
문제제목 : 사다리 타기
난이도 : 실버 1
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 문자열

알고리즘 설명
1. 위에서 부터 초기값("ABCDE...")으로 사다리 타고 아래서부터 결과값으로 사다리 탄다.
2. ?????... 이전과 이후를 비교하면서 같으면 *, 해당위치와 다음위치가 서로 스왑가능하면 - 넣고 스왑, 이외의 경우 불가능한 경우 xxx...
3. 결과 출력

채점 결과 : 140ms/14432KB
풀이 날짜 : 2021/09/29
*/

public class B2469 {
    static int k, n;
    static int[] before, after;
    static String[] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        String result = br.readLine();
        ladder = new String[n];
        before = new int[k];
        after = new int[k];
        for (int i = 0; i < result.length(); i++) {
            after[i] = result.charAt(i) - 'A';
        }
        for (int i = 0; i < k; i++) {
            before[i] = i;
        }
        for (int i = 0; i < n; i++) {
            ladder[i] = br.readLine();
        }

        int idx = 0;
        while (true) {
            String cur = ladder[idx];

            if (cur.charAt(0) == '?') {
                break;
            }

            for (int i = 0; i < cur.length(); i++) {
                char state = cur.charAt(i);

                if (state == '-') {
                    int temp = before[i];
                    before[i] = before[i+1];
                    before[i+1] = temp;
                }
            }

            idx++;
        }

        idx = n - 1;
        while (true) {
            String cur = ladder[idx];

            if (cur.charAt(0) == '?') {
                break;
            }

            for (int i = 0; i < cur.length(); i++) {
                char state = cur.charAt(i);

                if (state == '-') {
                    int temp = after[i];
                    after[i] = after[i+1];
                    after[i+1] = temp;
                }
            }

            idx--;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < k - 1; i++) {
            if (before[i] == after[i]) {
                sb.append("*");
            } else if (before[i] == after[i+1] && after[i] == before[i+1]) {
                sb.append("-");
                int temp = before[i];
                before[i] = before[i+1];
                before[i+1] = temp;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            bw.write(sb.toString());
        } else {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < k - 1; i++) {
                temp.append("x");
            }
            bw.write(temp.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
