package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1107
문제제목 : 리모컨
난이도 : 골드 5
제한사항 : 2초/256MB
알고리즘 분류 : 브루트포스 알고리즘

알고리즘 설명
1. n까지 +, -로만 움직이는 경우와
2. n과 가까운 번호를 누르고 +, -로 움직이는 경우를 봐준다.
3. 두 번째는 가까운 번호를 체크할 때 각 자리의 숫자 중 고장난 버튼 숫자가 하나라도 있으면 해당 숫자는 가지 못하므로 0 리턴
4. 아닌경우 각 자리 누르는 횟수 + 1씩 해준다.
5. 두 경우를 비교해서 작은 값 확인

채점 결과 : 192ms/16808KB
풀이 날짜 : 2021/10/12
*/

public class B1107 {
    static int n, m;
    static boolean[] broke;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        broke = new boolean[10];

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int button = Integer.parseInt(st.nextToken());
                broke[button] = true;
            }
        }

        int minCnt = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            int count = check(i);
            if (count > 0) {
                int press = Math.abs(n - i);
                minCnt = Math.min(minCnt, press + count);
            }
        }

        bw.write(minCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int check(int n) {
        if (n == 0) {
            if (broke[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int count = 0;
        while (n > 0) {
            if (broke[n % 10]) {
                return 0;
            }
            n /= 10;
            count++;
        }

        return count;
    }
}
