package Programmers.level3;

public class Prob12920 {
    public int solution(int n, int[] cores) {
        if (n < cores.length) {
            return n;
        }

        int remain = n - cores.length;
        for (int time = 1;; time++) {
            for (int i = 0; i < cores.length; i++) {
                if (time % cores[i] == 0) {
                    if (--remain == 0) {
                        return i + 1;
                    }
                }
            }
        }
    }
}
