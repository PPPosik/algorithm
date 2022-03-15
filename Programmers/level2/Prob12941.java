package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob12941 {
    public int solution(int[] A, int[] B) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        Arrays.sort(A);
        for (int b : B) {
            list.add(b);
        }
        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i] + " " + list.get(i));
            answer += A[i] * list.get(i);
        }

        return answer;
    }
}
