package Programmers.level3;

public class Prob49191 {
    public int solution(int n, int[][] results) {
        int[][] tree = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            tree[i][i] = 1;
        }

        for (int[] result : results) {
            tree[result[0] - 1][result[1] - 1] = 1;
            tree[result[1] - 1][result[0] - 1] = 2;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (tree[i][k] == 1 && tree[k][j] == 1) {
                        tree[i][j] = 1;
                    } else if (tree[i][k] == 2 && tree[k][j] == 2) {
                        tree[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (tree[i][j] == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}
