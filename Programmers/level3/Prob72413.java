package Programmers.level3;

public class Prob72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] distance = initDistance(n, fares);

        return getAnswer(n, distance, s, a, b);
    }

    private int getAnswer(int n, int[][] distance, int s, int a, int b) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, getMinCost(distance, s, i, a, b));
        }

        return answer;
    }

    private int getMinCost(int[][] distance, int start, int k, int end1, int end2) {
        int val1 = distance[start][k];
        int val2 = distance[k][end1];
        int val3 = distance[k][end2];

        if (val1 == Integer.MAX_VALUE || val2 == Integer.MAX_VALUE || val3 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return val1 + val2 + val3;
        }
    }

    private int[][] initDistance(int n, int[][] fares) {
        int[][] distance = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                distance[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] arr : fares) {
            distance[arr[0]][arr[1]] = arr[2];
            distance[arr[1]][arr[0]] = arr[2];
        }

        floydWarshall(n, distance);

        return distance;
    }

    private void floydWarshall(int n, int[][] distance) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
    }
}
