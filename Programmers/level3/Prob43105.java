package Programmers.level3;

public class Prob43105 {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[i + 1];
        }

        dp[0][0] = triangle[0][0];

        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1]);
            }
        }

        int answer = 0;
        for (int n : dp[dp.length - 1]) {
            answer = Math.max(answer, n);
        }

        return answer;
    }
}
