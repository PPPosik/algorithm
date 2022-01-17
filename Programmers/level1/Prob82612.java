package Programmers.level1;

public class Prob82612 {
    public long solution(int price, int money, int count) {
        long sum = 0;

        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }

        return Math.max(sum - money, 0);
    }
}
