package Programmers.level2;

public class Prob12905 {
    public int solution(int[][] board) {
        int[][] dp = board.clone();
        int answer = 0;

        if (board.length == 1 || board[0].length == 1) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (board[i][j] > 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
}
