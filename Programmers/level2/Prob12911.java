package Programmers.level2;

public class Prob12911 {
    public int solution(int n) {
        int cnt = countOne(n);

        while (cnt != countOne(++n));

        return n;
    }

    private int countOne(int n) {
        int ret = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                ret++;
            }

            n /= 2;
        }

        return ret;
    }
}
