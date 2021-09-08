package programmers.heap;

import java.util.TreeMap;

public class P42628 {
    public static void main(String[] args) {

    }

    static int[] solution(String[] operations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // 숫자, 수량
        for (String o : operations) {
            String[] order = o.split(" ");
            if (order[0].equals("I")) {
                int num = Integer.parseInt(order[1]);
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            } else {
                if (order[1].equals("1")) {
                    if (!treeMap.isEmpty()) {
                        int temp = treeMap.lastKey();
                        treeMap.put(temp, treeMap.get(temp) - 1);
                        if (treeMap.get(temp) == 0) {
                            treeMap.remove(temp);
                        }
                    }
                } else {
                    if (!treeMap.isEmpty()) {
                        int temp = treeMap.firstKey();
                        treeMap.put(temp, treeMap.get(temp) - 1);
                        if (treeMap.get(temp) == 0) {
                            treeMap.remove(temp);
                        }
                    }
                }
            }
        }

        int[] answer = new int[2];
        if (treeMap.isEmpty()) {
            return answer;
        } else {
            answer[0] = treeMap.lastKey();
            answer[1] = treeMap.firstKey();
        }

        return answer;
    }
}
