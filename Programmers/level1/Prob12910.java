package Programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob12910 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> divided = new ArrayList<Integer>();

        for (int n : arr) {
            if (n % divisor == 0) {
                divided.add(n);
            }
        }

        if (divided.size() == 0) {
            divided.add(-1);
        }

        int[] answer = new int[divided.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = divided.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
