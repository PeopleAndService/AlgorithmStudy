package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

/*
플랫폼 : 백준
문제번호 : 1074
문제제목 : Z
난이도 : 실버 1
제한사항 : 0.5초/512MB
알고리즘 분류 : 분할 정복, 재귀

알고리즘 설명
1. 재귀
2. r, c가 몇 사분면에 속하는지 찾아준다.
3. 재귀 돌때마다 배열 사이즈 반 씩
4. 현재 배열 크기에서 속하는 4분면을 찾았으면, 해당 4분면에서의 상대 위치 좌표를 갱신

채점 결과 : 132ms/14336KB
풀이 날짜 : 2021/09/22
*/

public class B1074 {
    static int n, targetR, targetC, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        targetR = Integer.parseInt(st.nextToken());
        targetC = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        idx = 0;
        dfs(targetR, targetC, size);
        bw.write(idx + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int step) {
        if (step == 1) {
            return;
        }

        if (r < step / 2 && c < step / 2) {
            dfs(r, c, step / 2);
        } else if (r < step / 2 && c >= step / 2) {
            idx += step * step / 4;
            dfs(r, c - step / 2, step / 2);
        } else if (r >= step / 2 && c < step / 2) {
            idx += (step * step / 4) * 2;
            dfs(r - step / 2, c, step / 2);
        } else {
            idx += (step * step / 4) * 3;
            dfs(r - step / 2, c - step / 2, step / 2);
        }
    }
}
