package Programmers.level3;

import java.util.Arrays;

public class Prob42861 {
    public int solution(int n, int[][] costs) {
        int[] nodes = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            nodes[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> {
            int[] edge1 = (int[]) o1;
            int[] edge2 = (int[]) o2;

            return edge1[2] - edge2[2];
        });
        
        for(int[] arr : costs) {
            if(find(nodes, arr[0]) != find(nodes, arr[1])) {
                union(nodes, arr[0], arr[1]);
                answer += arr[2];
            }
        }

        return answer;
    }
    
    private int find(int[] nodes, int n) {
        if(nodes[n] == n) {
            return n;
        }
        
        return nodes[n] = find(nodes, nodes[n]);
    }
    
    private void union(int[] nodes, int n1, int n2) {
        int p1 = find(nodes, n1);
        int p2 = find(nodes, n2);
        
        nodes[Math.max(p1, p2)] = Math.min(p1, p2);
    }
}