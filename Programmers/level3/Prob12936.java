package Programmers.level3;

import java.util.ArrayList;

public class Prob12936 {
    public int[] solution(int n, long k) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int[] answer = new int[n];

        long val = 1;
        for (int i = 1; i <= n; i++) {
            val *= i;
            numbers.add(i);
        }

        k--;
        for (int i = n; i > 0; i--) {
            val /= i;
            answer[n - i] = numbers.remove((int) (k / val));
            k %= val;
        }

        return answer;
    }
}
