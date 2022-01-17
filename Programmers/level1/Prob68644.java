package Programmers.level1;

import java.util.Arrays;
import java.util.HashSet;

public class Prob68644 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<Integer>();
        int[] answer;
        int idx = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }

        answer = new int[set.size()];
        for (int number : set) {
            answer[idx++] = number;
        }
        Arrays.sort(answer);

        return answer;
    }
}
