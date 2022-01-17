package Programmers.level1;

import java.util.ArrayList;

public class Prob12906 {
    public int[] solution(int []arr) {
        ArrayList<Integer> answerWrapperType = new ArrayList<Integer>();
        
        int before = arr[0];
        answerWrapperType.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == before) {
                continue;
            }

            before = arr[i];
            answerWrapperType.add(arr[i]);
        }

        int[] answer = new int[answerWrapperType.size()];
        int idx = 0;
        for(int num: answerWrapperType) {
            answer[idx++] = num;
        }

        return answer;
    }
}
