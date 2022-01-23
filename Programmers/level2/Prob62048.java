package Programmers.level2;

public class Prob62048 {
    public long solution(int w, int h) {
        return ((long) w * h) - (w + h - gcd(w, h));
    }

    private int gcd(int a, int b) {
        int n1 = Math.max(a, b);
        int n2 = Math.min(a, b);

        if (n1 % n2 == 0) {
            return n2;
        } else {
            return gcd(n1 % n2, n2);
        }
    }
}
