package baekjoon.class3;

import java.io.*;
import java.util.HashMap;

/*
플랫폼 : 백준
문제번호 : 9375
문제제목 : 패션왕 신해빈
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 자료구조, 해시를 사용한 집합과 맵

알고리즘 설명
1. 맵에 의상 분류, 종류의 엔트리로 값 집어 넣음 -> 기본값 = 1
2. 종류를 다 곱해주고 -1 하면 입을 수 있는 옷 조합 수
프로그래머스 해시에 있는 위장과 비슷한 문제

채점 결과 : 160ms/15212KB
풀이 날짜 : 2021/09/20
*/

public class B9375 {
    static int t, n;
    static HashMap<String, Integer> cloth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            cloth = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                cloth.put(input[1], cloth.getOrDefault(input[1], 1) + 1);
            }
            int count = 1;
            for (int v : cloth.values()) {
                count *= v;
            }
            count--;
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
