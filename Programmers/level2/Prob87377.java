package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob87377 {
    public String[] solution(int[][] line) {
        ArrayList<long[]> list = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                double denominator = (long) line[i][0] * line[j][1] - (long) line[i][1] * line[j][0];

                if (denominator != 0) {
                    double y = ((long) line[j][0] * line[i][2] - (long) line[i][0] * line[j][2]) / denominator;
                    double x = ((long) line[i][1] * line[j][2] - (long) line[i][2] * line[j][1]) / denominator;

                    if (x % 1 == 0 && y % 1 == 0) {
                        list.add(new long[] { (long) x, (long) y });
                    }
                }
            }
        }

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        for (long[] arr : list) {
            minX = Math.min(minX, arr[0]);
            maxX = Math.max(maxX, arr[0]);
            minY = Math.min(minY, arr[1]);
            maxY = Math.max(maxY, arr[1]);
        }

        char[][] answerArr = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        for (int i = 0; i < answerArr.length; i++) {
            Arrays.fill(answerArr[i], '.');
        }

        for (long[] arr : list) {
            answerArr[(int) (arr[1] - minY)][(int) (arr[0] - minX)] = '*';
        }

        String[] answer = new String[answerArr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[answer.length - i - 1] = new String(answerArr[i]);
        }

        return answer;
    }
}
