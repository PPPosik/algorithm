package Programmers.level3;

public class Prob43238 {
    public long solution(int n, int[] times) {
        long left = 0, right = 1000000000L * 100000L;

        while (left < right) {
            long mid = (left + right) / 2;

            if (isPossible(n, times, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isPossible(int n, int[] times, long target) {
        long sum = 0;

        for (int time : times) {
            sum += target / time;
        }

        return sum >= n;
    }
}
