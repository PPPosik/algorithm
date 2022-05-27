package Programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prob12927 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.offer(work);
        }

        while (n > 0 && !queue.isEmpty()) {
            int value = queue.poll() - 1;

            if (value > 0) {
                queue.add(value);
            }

            n--;
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }

        return answer;
    }
}
