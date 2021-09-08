package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    public static void main(String[] args) {

    }

    static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> part = new HashMap<>();

        for (String p : participant) {
            part.put(p, part.getOrDefault(p, 0) + 1);
        }

        String answer = "";

        for (String c : completion) {
            part.put(c, part.get(c) - 1);
        }

        for (Map.Entry<String, Integer> e : part.entrySet()) {
            if (e.getValue() != 0) {
                answer = e.getKey();
            }
        }

        return answer;
    }
}
