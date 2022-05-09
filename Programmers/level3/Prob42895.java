package Programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;

public class Prob42895 {
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        int answer = -1;

        init(dp, N);

        for (int i = 1; i <= 8; i++) {
            if (calc(dp, number, i) != -1) {
                answer = i;
                break;
            }

            for (int aa : dp.get(i)) {
                System.out.print(aa + " ");
            }
            System.out.println();
        }

        return answer;
    }

    private void init(ArrayList<HashSet<Integer>> dp, int N) {
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }

        int i = 0, digit = 0;
        while (digit < 8) {
            i = i * 10 + N;
            digit++;
            dp.get(digit).add(i);
        }
    }

    private int calc(ArrayList<HashSet<Integer>> dp, int target, int idx) {
        if(dp.get(idx).contains(target)) {
            return idx;
        }

        for (int i = 1; i <= idx / 2; i++) {
            for (int n1 : dp.get(i)) {
                for (int n2 : dp.get(idx - i)) {
                    int[] values = new int[] { n1 + n2, n1 - n2, n2 - n1, n1 * n2, n1 / n2, n2 / n1 };

                    for (int value : values) {
                        if (value == target) {
                            return idx;
                        }

                        if (value != 0) {
                            dp.get(idx).add(value);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
