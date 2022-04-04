package Programmers.level2;

public class Prob86971 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            answer = Math.min(answer, calcDifference(wires, n, i));
        }

        return answer;
    }

    private int calcDifference(int[][] wires, int n, int excludeIdx) {
        int[] nodes = new int[n + 1];

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < wires.length; i++) {
            if (i != excludeIdx) {
                union(nodes, wires[i][0], wires[i][1]);
            }
        }

        int[] cnt = new int[n + 1];
        for (int i = 1; i < nodes.length; i++) {
            find(nodes, i);
            cnt[nodes[i]]++;
        }

        int group1 = Integer.MIN_VALUE, group2 = Integer.MAX_VALUE;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                group1 = Math.max(group1, cnt[i]);
                group2 = Math.min(group2, cnt[i]);
            }
        }

        return group1 - group2;
    }

    private void union(int[] nodes, int node1, int node2) {
        node1 = find(nodes, node1);
        node2 = find(nodes, node2);

        if (node1 != node2) {
            nodes[node2] = node1;
        }
    }

    private int find(int[] nodes, int node) {
        if (nodes[node] == node) {
            return node;
        } else {
            return nodes[node] = find(nodes, nodes[node]);
        }
    }
}
