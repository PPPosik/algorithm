package Programmers.level1;

public class Prob12940 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);

        return answer;
    }

    private int gcd(int a, int b) {
        int num1 = Math.max(a, b);
        int num2 = Math.min(a, b);

        if (num1 % num2 == 0) {
            return num2;
        } else {
            return gcd(num2, num1 % num2);
        }
    }

    private int lcm(int a, int b) {
        // overflow 방지
        return a * (b / gcd(a, b));
    }
}
