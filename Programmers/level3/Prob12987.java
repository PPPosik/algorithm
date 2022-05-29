package Programmers.level3;

import java.util.Arrays;

public class Prob12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                answer++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return answer;
    }
}
