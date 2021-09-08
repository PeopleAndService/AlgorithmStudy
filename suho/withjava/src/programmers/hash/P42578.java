package programmers.hash;

import java.util.HashMap;

public class P42578 {
    public static void main(String[] args) {

    }

    static int solution(String[][] clothes) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String[] c : clothes) {
            count.put(c[1], count.getOrDefault(c[1], 1) + 1);
        }

        int answer = 1;
        for (Integer v : count.values()) {
            answer *= v;
        }

        return answer - 1;
    }
}
