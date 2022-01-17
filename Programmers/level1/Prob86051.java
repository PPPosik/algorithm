package Programmers.level1;

public class Prob86051 {
    public int solution(int[] numbers) {
        boolean[] showedNumber = { false, false, false, false, false, false, false, false, false, false };
        int answer = 0;

        for (int number : numbers) {
            showedNumber[number] = true;
        }

        for (int i = 0; i < showedNumber.length; i++) {
            if (showedNumber[i] == false) {
                answer += i;
            }
        }

        return answer;
    }
}
