package Programmers.level2;

public class Prob12953 {
    public int solution(int[] arr) {
        int lcmVal = 1;

        for (int n : arr) {
            lcmVal = lcm(lcmVal, n);
        }

        return lcmVal;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if (max % min == 0) {
            return min;
        } else {
            return gcd(max % min, min);
        }
    }
}
