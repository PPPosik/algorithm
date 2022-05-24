package Programmers.level3;

public class Prob12938 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (s / n == 0) {
            return new int[] { -1 };
        }

        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }

        for (int i = 0; i < s % n; i++) {
            answer[n - 1 - i]++;
        }

        return answer;
    }
}
