package baekjoon.class3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 17219
문제제목 : 비밀번호 찾기
난이도 : 실버 4
제한사항 : 5초/256MB
알고리즘 분류 : 자료구조, 해시를 사용한 집합과 맵

알고리즘 설명
해시맵 구현 문제

채점 결과 : 668ms/58512KB
풀이 날짜 : 2021/09/17
*/

public class B17219 {
    static int n, m;
    static HashMap<String, String> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            memo.put(site, pw);
        }
        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            bw.write(memo.get(target) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
