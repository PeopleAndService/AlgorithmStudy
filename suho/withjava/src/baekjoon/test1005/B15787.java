package baekjoon.test1005;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 15787
문제제목 : 기차가 어둠을 헤치고 은하수를
난이도 : 실버 2
제한사항 : 1초/512MB
알고리즘 분류 : 구현, 비트마스킹

알고리즘 설명
1. x번째 좌석에 승객을 태우는 경우는 1 << x와 현재 기차 상태를 or 연산
2. x번째 좌석의 승객을 하차하는 경우는 1 << x의 보수와 현재 기차 상태를 and 연산 -> 1인 경우만 1로 남음
3. 승객들을 모두 한 킨씩 뒤로 보내는 경우는 좌측시프트연산, 20자리만 유효하기 때문에 시프트한 결과를 20자리의 1로 채워진 비트와 and 연산
4. 승객들을 모두 한 칸씩 앞으로 보내는 경우는 우측시프트연산, 1인 경우 처리를 위해 ~1과 and 연산

채점 결과 : 416ms/39096KB
풀이 날짜 : 2021/10/05
*/

public class B15787 {
    static int n, m;
    static int[] train;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        train = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int x;

            if (order == 1) {
                x = Integer.parseInt(st.nextToken());

                train[t] |= 1 << x;
            } else if (order == 2) {
                x = Integer.parseInt(st.nextToken());

                train[t] &= ~(1 << x);
            } else if (order == 3) {
                train[t] <<= 1;
                train[t] &= ((1 << 21) - 1);
            } else if (order == 4) {
                train[t] >>= 1;
                train[t] &= ~1;
            }
        }

        HashSet<Integer> result = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            result.add(train[i]);
        }

        bw.write(result.size() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
