package Programmers.level2;

import java.util.Arrays;

public class Prob49993 {
    public int solution(String skill, String[] skill_trees) {
        int[] idx = new int[skill.length()];
        char[] charArr = skill.toCharArray();
        int answer = 0;

        for (String str : skill_trees) {
            Arrays.fill(idx, -1);

            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < charArr.length; j++) {
                    if (arr[i] == charArr[j]) {
                        idx[j] = i;
                    }
                }
            }

            if (isPossible(idx)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPossible(int[] idx) {
        for (int i = 0; i < idx.length - 1; i++) {
            if (idx[i] == -1 && idx[i + 1] != -1) {
                return false;
            } else if (idx[i + 1] != -1 && idx[i] > idx[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
