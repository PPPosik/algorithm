package Programmers.level3;

public class Prob12920 {
    public int solution(int n, int[] cores) {
        int[] work = new int[cores.length];

        while (n > 0) {
            int minVal = Integer.MAX_VALUE;

            for (int i = 0; i < work.length; i++) {
                minVal = Math.min(minVal, work[i]);
            }

            for (int i = 0; i < work.length; i++) {
                if (work[i] == 0) {
                    work[i] = cores[i];
                    if (--n == 0) {
                        return i + 1;
                    }
                } else {
                    work[i] -= minVal;
                }
            }
        }

        return 0;
    }
}
