package Programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class Prob12933 {
    public long solution(long n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        long answer = 0;

        while (n > 0) {
            arr.add((int) (n % 10));
            n /= 10;
        }
        Collections.sort(arr);

        long digit = 1;
        for (int num : arr) {
            answer += num * digit;
            digit *= 10;
        }

        return answer;
    }
}
