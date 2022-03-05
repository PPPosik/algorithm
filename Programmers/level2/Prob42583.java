package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Prob42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int nowWeight = 0;
        int answer = 0;

        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }

        int idx = 0;
        while (idx < truck_weights.length) {
            nowWeight -= queue.poll();

            if (nowWeight + truck_weights[idx] <= weight) {
                queue.offer(truck_weights[idx]);
                nowWeight += truck_weights[idx];
                idx++;
            } else {
                queue.offer(0);
            }

            answer++;
        }

        int dequeueCnt = 0;
        for (int i = 0; !queue.isEmpty(); i++) {
            if (queue.poll() != 0) {
                dequeueCnt = i + 1;
            }
        }

        return answer + dequeueCnt;
    }
}
