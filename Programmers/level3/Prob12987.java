package Programmers.level3;

import java.util.PriorityQueue;

public class Prob12987 {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            queue1.offer(A[i]);
            queue2.offer(B[i]);
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peek() < queue2.peek()) {
                answer++;
                queue1.poll();
                queue2.poll();
            } else {
                queue2.poll();
            }
        }

        return answer;
    }
}
