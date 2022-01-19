package Programmers.level1;

public class Prob12944 {
    public double solution(int[] arr) {
        double answer = 0;

        for (int num : arr) {
            answer += num;
        }
        answer /= arr.length;

        return answer;
    }
}
