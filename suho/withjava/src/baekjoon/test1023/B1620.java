package baekjoon.test1023;

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
1. 맵 사용해서 인덱스와 이름 맵 두가지 사용

채점 결과 : 668ms/54408KB
풀이 날짜 : 2021/10/23
*/

public class B1620 {
    static int n, m;
    static HashMap<Integer, String> index;
    static HashMap<String, Integer> name;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        index = new HashMap<>();
        name = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            index.put(i, input);
            name.put(input, i);
        }
        for (int i = 0; i < m; i++) {
            String order = br.readLine();
            if ('1' <= order.charAt(0) && order.charAt(0) <= '9') {
                bw.write(index.get(Integer.parseInt(order)) + "\n");
            } else {
                bw.write(name.get(order) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
