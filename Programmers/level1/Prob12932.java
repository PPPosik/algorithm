package Programmers.level1;

import java.util.ArrayList;

public class Prob12932 {
    public int[] solution(long n) {
        ArrayList<Integer> numArr = new ArrayList<Integer>();

        while (n > 0) {
            numArr.add((int) (n % 10));
            n /= 10;
        }

        int[] answer = new int[numArr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numArr.get(i);
        }

        return answer;
    }
}
