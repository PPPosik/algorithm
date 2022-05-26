package Programmers.level3;

import java.util.Arrays;

public class Prob12907 {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        Arrays.sort(money);

        dp[0] = 1;
        for (int m : money) {
            for (int i = 1; i <= n; i++) {
                if (i - m >= 0) {
                    dp[i] = (dp[i] + dp[i - m]) % 1000000007;
                }
            }
        }

        return dp[n];
    }
}
