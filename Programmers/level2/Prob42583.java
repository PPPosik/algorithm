package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Prob42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int[] queueSize = new int[truck_weights.length];
        int nowWeight = 0;
        int answer = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            boolean isPolled = false;

            if (nowWeight + truck_weights[i] > weight || queue.size() > bridge_length) {
                isPolled = true;
                int idx = queue.poll();
                System.out.print("poll " + truck_weights[idx]);
                nowWeight -= truck_weights[idx];
                answer += bridge_length - queueSize[idx];
                System.out.println(" " + answer);
            }

            if (nowWeight + truck_weights[i] <= weight && queue.size() <= bridge_length) {
                queueSize[i] = queue.size();
                queue.offer(i);
                nowWeight += truck_weights[i];

                if (!isPolled) {
                    answer++;
                }
                System.out.println("offer " + i + " " + answer);
            }
        }

        answer += bridge_length - queueSize[queueSize.length - queue.size()];

        return answer;
    }
}
