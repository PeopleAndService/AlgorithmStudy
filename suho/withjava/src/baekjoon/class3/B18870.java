package baekjoon.class3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 18870
문제제목 : 좌표 압축
난이도 : 실버 2
제한사항 : 2초/512MB
알고리즘 분류 : 정렬, 좌표 압축

알고리즘 설명
1. 기존 배열을 복사해서 오름차순 정렬
2. 정렬된 배열 탐색하면서 map에 등장하는 인덱스를 넣어준다.
3. 기존 배열 돌면서 map의 값을 출력해주면 좌표압축

채점 결과 : 2044ms/268668KB
풀이 날짜 : 2021/09/22
*/

public class B18870 {
    static int n;
    static int[] arr, sorted;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sorted = arr.clone();
        Arrays.sort(sorted);
        map = new HashMap<>();
        int idx = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }
        for (int num : arr) {
            bw.write(map.get(num) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
