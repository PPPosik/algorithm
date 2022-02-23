package Programmers.level2;

public class Prob42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int num = brown + yellow;

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (2 * (i + num / i) - 4 == brown) {
                    answer[0] = Math.max(i, num / i);
                    answer[1] = Math.min(i, num / i);
                }
            }
        }

        return answer;
    }
}
