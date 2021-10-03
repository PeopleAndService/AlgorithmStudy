package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 6064
문제제목 : 카잉 달력
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : 수학, 정수론, 중국인의 나머지 정리

알고리즘 설명
1. x의 값을 고정하고 count와 y값을 갱신해나간다.
2. 원하는 y값을 찾은 경우 count가 정답
3. 만약 count가 m, n의 최소공배수보다 크다면 예외 (-1을 출력하는)
4. y값은 갱신하는 y값을 n으로 나눈 값이된다.

채점 결과 : 784ms/46268KB
풀이 날짜 : 2021/10/03
*/

public class B6064 {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = x % (m + 1);
            int updateY = x;

            for (int i = 0; i < n; i++) {
                int temp = updateY % n == 0 ? n : updateY % n;
                if (temp == y) {
                    break;
                }

                updateY = temp + m;
                count += m;
            }

            if (count > lcm(m, n)) {
                bw.write("-1\n");
            } else {
                bw.write(count + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
