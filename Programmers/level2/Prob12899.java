package Programmers.level2;

public class Prob12899 {
    public String solution(int n) {
        int[] decimal = { 1, 2, 4 };
        StringBuilder answer = new StringBuilder();

        int digit = 1;
        for (int i = 1; Math.pow(3, i) < n; i++) {
            n -= Math.pow(3, i);
            digit = i + 1;
        }

        String str = Integer.toString(n - 1, 3);
        for (int i = 0; i < digit - str.length(); i++) {
            answer.append('1');
        }
        for (char c : str.toCharArray()) {
            answer.append(decimal[Character.getNumericValue(c)]);
        }

        return answer.toString();
    }
}
