package programmers.stackqueue;

import java.util.LinkedList;

public class P42587 {
    public static void main(String[] args) {

    }

    static int solution(int[] priorities, int location) {
        LinkedList<document> printQ = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printQ.offer(new document(i, priorities[i]));
        }

        int order = 0;
        while (!printQ.isEmpty()) {
            document cur = printQ.poll();
            boolean isPrint = true;
            for (int i = 0; i < printQ.size(); i++) {
                if (cur.priority < printQ.get(i).priority) {
                    printQ.offer(cur);
                    for (int j = 0; j < i; j++) {
                        printQ.offer(printQ.poll());
                    }
                    isPrint = false;
                    break;
                }
            }

            if (!isPrint) {
                continue;
            }

            order++;
            if (cur.idx == location) {
                break;
            }
        }

        return order;
    }

    static class document {
        int idx, priority;

        public document(int i, int p) {
            this.idx = i;
            this.priority = p;
        }
    }
}
