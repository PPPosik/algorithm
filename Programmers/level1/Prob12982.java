package Programmers.level1;

import java.util.Arrays;

public class Prob12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (int n : d) {
            if (budget < n) {
                break;
            }

            budget -= n;
            answer++;
        }

        return answer;
    }
}
