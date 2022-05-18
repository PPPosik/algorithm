package Programmers.level3;

import java.util.*;

public class Prob42884 {
    public int solution(int[][] routes) {
        ArrayList<Range> list = new ArrayList<>();

        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

        for (int[] route : routes) {
            if (!checkAndUpdate(list, route)) {
                list.add(new Range(route[0], route[1]));
            }
        }

        return list.size();
    }

    private boolean checkAndUpdate(ArrayList<Range> list, int[] route) {
        for (int i = 0; i < list.size(); i++) {
            if (isOverlapped(list.get(i).min, list.get(i).max, route[0], route[1])) {
                list.get(i).min = Math.max(list.get(i).min, route[0]);
                list.get(i).max = Math.min(list.get(i).max, route[1]);

                return true;
            }
        }

        return false;
    }

    private boolean isOverlapped(int min1, int max1, int min2, int max2) {
        if (max1 < min2 || max2 < min1) {
            return false;
        } else {
            return true;
        }
    }

    class Range {
        int max;
        int min;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
