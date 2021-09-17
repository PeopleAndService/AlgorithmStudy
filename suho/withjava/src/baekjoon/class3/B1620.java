package baekjoon.class3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1620
문제제목 : 나는야 포켓몬 마스터 이다솜
난이도 : 실버 4
제한사항 : 2초/256MB
알고리즘 분류 : 자료구조, 해시를 사용한 집합과 맵

알고리즘 설명
1. 포켓몬 도감에는 번호와 이름이 담겨있음
2. 질문이 번호나 이름으로 들어오기 때문에 각각을 담는 맵 사용

채점 결과 : 576ms/54116KB
풀이 날짜 : 2021/09/17
*/

public class B1620 {
    static int n, m;
    static HashMap<Integer, String> idxMap;
    static HashMap<String, Integer> nameMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        idxMap = new HashMap<>();
        nameMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            idxMap.put(i, name);
            nameMap.put(name, i);
        }
        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            if ('1' <= target.charAt(0) && target.charAt(0) <= '9') {
                int idx = Integer.parseInt(target);
                bw.write(idxMap.get(idx) + "\n");
            } else {
                bw.write(nameMap.get(target) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
