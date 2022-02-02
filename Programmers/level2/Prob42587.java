package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Prob42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<Pair>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Pair(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            int highPriority = -1;

            for (Pair pair : queue) {
                highPriority = Math.max(highPriority, pair.first);
            }

            while (true) {
                Pair tmp = queue.poll();
                if (tmp.first == highPriority) {
                    answer++;

                    if (tmp.second == location) {
                        return answer;
                    }

                    break;
                } else {
                    queue.offer(tmp);
                }
            }
        }

        return -1;
    }

    private class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
