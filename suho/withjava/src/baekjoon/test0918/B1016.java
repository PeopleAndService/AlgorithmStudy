package baekjoon.test0918;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1016
문제제목 : 제곱ㄴㄴ수
난이도 : 골드 1
제한사항 : 2초/512MB
알고리즘 분류 : 수학, 정수론, 소수 판정, 에라토스테네스의 체

알고리즘 설명
1. 배열의 크기는 정수 범위만 되므로 max - min + 1이 배열의 크기임
2. max의 제곱근을 구한다.
3. 2부터 max의 제곱근까지 반복하면서
4. i의 제곱을 구한다.
5. min을 i의 제곱으로 나눠서 나누어 떨어지면 몫부터 시작, 나누어 떨어지지 않으면 몫 + 1부터 시작
6. 몫과 i제곱의 곱의 값이 max이하일때까지 반복
7. check배열의 값을 true로 마스킹 -> 제곱수라는 뜻
8. check배열 돌면서 false를 세준다 -> 제곱ㄴㄴ수 카운팅

채점 결과 : 188ms/15392KB
풀이 날짜 : 2021/09/19
*/

public class B1016 {
    static long min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        int size = (int) (max - min + 1);
        int sqrt = (int) Math.sqrt(max);

        boolean[] check = new boolean[size];

        for (long i = 2; i <= sqrt; i++) {
            long square = i * i;
            long start = min % square == 0 ? min / square : min / square + 1;

            for (long j = start; j * square <= max; j++) {
                check[(int) (j * square - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!check[i]) count++;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
