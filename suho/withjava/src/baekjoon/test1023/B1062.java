package baekjoon.test1023;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1062
문제제목 : 가르침
난이도 : 골드 4
제한사항 : 1초/512MB
알고리즘 분류 : 브루트포스 알고리즘, 비트마스킹, 백트래킹

알고리즘 설명
1. 백트래킹으로 알파벳 사용 여부를 조합해가면서 읽을 수 있는 단어 수 체크

채점 결과 : 328ms/16940KB
풀이 날짜 : 2021/10/23
*/

public class B1062 {
    static int n, k, result, count;
    static String[] words;
    static boolean[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        result = 0;

        if (k >= 5) {
            words = new String[n];

            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                words[i] = input.substring(4, input.length() - 4);
            }

            alpha = new boolean[26];
            alpha['a'-'a'] = true;
            alpha['c'-'a'] = true;
            alpha['i'-'a'] = true;
            alpha['n'-'a'] = true;
            alpha['t'-'a'] = true;

            count = k - 5;

            dfs(1, 0);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int alphaIdx, int alphaCnt) {
        if (alphaCnt == count) {
            int readWords = check();
            result = Math.max(result, readWords);
            return;
        }

        if (alphaIdx >= 26) {
            return;
        }

        if (!alpha[alphaIdx]) {
            alpha[alphaIdx] = true;
            dfs(alphaIdx + 1, alphaCnt + 1);
            alpha[alphaIdx] = false;
        }

        dfs(alphaIdx + 1, alphaCnt);
    }

    static int check() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = words[i];
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                char cur = word.charAt(j);
                if (!alpha[cur-'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        return count;
    }
}
