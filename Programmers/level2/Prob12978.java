package Programmers.level2;

import java.util.Arrays;

public class Prob12978 {
    final int INF = 1000000000;

    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N + 1][N + 1];
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        int answer = 0;

        for (int[] g : graph) {
            Arrays.fill(g, INF);
        }
        Arrays.fill(distance, INF);

        for (int[] r : road) {
            graph[r[0]][r[1]] = Math.min(graph[r[0]][r[1]], r[2]);
            graph[r[1]][r[0]] = Math.min(graph[r[1]][r[0]], r[2]);
        }

        distance[1] = 0;
        dijkstra(graph, distance, visited, 1);

        for (int d : distance) {
            if (d <= K) {
                answer++;
            }
        }

        return answer;
    }

    private void dijkstra(int[][] graph, int[] distance, boolean[] visited, int idx) {
        visited[idx] = true;

        for (int i = 1; i < graph[idx].length; i++) {
            distance[i] = Math.min(distance[i], distance[idx] + graph[idx][i]);
        }

        int nextIdx = -1;
        int min = INF;
        for (int i = 1; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                nextIdx = i;
            }
        }

        if (nextIdx != -1) {
            dijkstra(graph, distance, visited, nextIdx);
        }
    }
}
