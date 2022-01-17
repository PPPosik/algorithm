package Programmers.level1;

public class Prob77884 {
    public int solution(int left, int right) {
        int answer = 0;
        int[] divisorCnt = new int[1001];

        for (int i = 1; i < 1001; i++) {
            for (int j = i; j < 1001; j++) {
                if (j % i == 0) {
                    divisorCnt[j]++;
                }
            }
        }

        for (int i = left; i <= right; i++) {
            answer += i * (divisorCnt[i] % 2 == 0 ? 1 : -1);
        }

        return answer;
    }
}
