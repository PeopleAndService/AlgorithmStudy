package baekjoon.class3;

import java.io.*;
import java.util.*;

/*
플랫폼 : 백준
문제번호 : 1764
문제제목 : 듣보잡
난이도 : 실버 4
제한사항 : 2초/256MB
알고리즘 분류 : 자료구조, 문자열, 정렬, 해시를 사용한 집합과 맵

알고리즘 설명
1. 듣기만 한 사람 set, 듣보잡인 사람 set
2. 듣보잡인 사람 set의 크기와 값 출력

채점 결과 : 376ms/26372KB
풀이 날짜 : 2021/09/17
*/

public class B1764 {
    static int n, m;
    static TreeSet<String> listen;
    static TreeSet<String> see;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        listen = new TreeSet<>();
        see = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            listen.add(name);
        }
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (listen.contains(name)) {
                see.add(name);
            }
        }

        bw.write(see.size() + "\n");
        for (String s : see) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
