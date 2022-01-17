package Programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class Prob42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> tmpArr = new ArrayList<Integer>();
            for (int idx = commands[i][0] - 1; idx < commands[i][1]; idx++) {
                tmpArr.add(array[idx]);
            }
            Collections.sort(tmpArr);
            answer[i] = tmpArr.get(commands[i][2] - 1);
        }

        return answer;
    }
}
