package Programmers.level2;

public class Prob12913 {
    public int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                    }
                }
            }
        }

        for (int n : dp[dp.length - 1]) {
            answer = Math.max(answer, n);
        }

        return answer;
    }
}