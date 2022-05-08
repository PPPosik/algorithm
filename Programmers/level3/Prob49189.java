package Programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prob49189 {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] depth = new int[n + 1];
        int answer = 0;

        Arrays.fill(depth, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        Queue<Integer> queue = new LinkedList();
        queue.offer(1);
        depth[1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < list.get(node).size(); i++) {
                int next = list.get(node).get(i);

                if (depth[next] > depth[node] + 1) {
                    depth[next] = depth[node] + 1;
                    queue.offer(next);
                }
            }
        }

        int max = -1;
        for (int value : depth) {
            if (value != Integer.MAX_VALUE) {
                max = Math.max(max, value);
            }
        }

        for (int value : depth) {
            if (max == value) {
                answer++;
            }
        }

        return answer;
    }
}
