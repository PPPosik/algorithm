package Programmers.level3;

import java.util.HashSet;

public class Prob43162 {
    public int solution(int n, int[][] computers) {
        int[] nodes = new int[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    union(nodes, i, j);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            find(nodes, i);
            set.add(nodes[i]);
        }

        return set.size();
    }

    private int find(int[] nodes, int node) {
        if (nodes[node] == node) {
            return node;
        } else {
            nodes[node] = find(nodes, nodes[node]);
            return nodes[node];
        }
    }

    private void union(int[] nodes, int x, int y) {
        x = find(nodes, x);
        y = find(nodes, y);

        nodes[Math.max(x, y)] = Math.min(x, y);
    }
}
