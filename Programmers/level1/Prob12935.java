package Programmers.level1;

public class Prob12935 {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int answerIdx = 0;
        int minVal = Integer.MAX_VALUE;

        if (arr.length == 1) {
            return new int[] { -1 };
        }

        for (int n : arr) {
            minVal = Math.min(minVal, n);
        }

        for (int n : arr) {
            if (n != minVal) {
                answer[answerIdx++] = n;
            }
        }

        return answer;
    }
}
