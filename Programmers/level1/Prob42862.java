package Programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Prob42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] student = new boolean[n];
        boolean[] result;

        Arrays.fill(student, true);
        for (int idx : lost) {
            student[idx - 1] = false;
        }
        result = Arrays.copyOf(student, n);

        Arrays.sort(reserve);
        for (int idx : reserve) {
            if (student[idx - 1]) {
                if (idx - 2 >= 0 && !result[idx - 2]) {
                    result[idx - 2] = true;
                } else if (idx < n && !result[idx]) {
                    result[idx] = true;
                }
            } else {
                result[idx - 1] = true;
            }
        }

        return (int) IntStream.range(0, n).filter(i -> result[i]).count();
    }
}
