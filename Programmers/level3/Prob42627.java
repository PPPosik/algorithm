package Programmers.level3;

import java.util.Collections;
import java.util.LinkedList;

public class Prob42627 {
    public int solution(int[][] jobs) {
        LinkedList<int[]> list = new LinkedList<>();
        int now = 0;

        for (int[] job : jobs) {
            list.add(job);
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

        int sum = 0;
        while (!list.isEmpty()) {
            int minTime = Integer.MAX_VALUE;
            int idx = -1;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] > now) {
                    break;
                }

                if (minTime > list.get(i)[1]) {
                    minTime = list.get(i)[1];
                    idx = i;
                }
            }

            if (idx == -1) {
                now += list.get(0)[0] - now;
            } else {
                sum += now - list.get(idx)[0] + minTime;
                now += minTime;
                list.remove(idx);
            }
        }

        return sum / jobs.length;
    }
}
