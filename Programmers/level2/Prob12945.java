package Programmers.level2;

public class Prob12945 {
    int[] memo;

    public int solution(int n) {
        memo = new int[100001];

        return fibo(n);
    }

    public int fibo(int n) {
        if (n <= 2) {
            return 1;
        } else if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = (fibo(n - 2) + fibo(n - 1)) % 1234567;

        return memo[n];
    }
}
