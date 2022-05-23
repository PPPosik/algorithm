package Programmers.level3;

import java.util.ArrayList;

public class Prob12946 {
    ArrayList<int[]> path = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3);

        int[][] answer = new int[path.size()][2];
        for (int i = 0; i < path.size(); i++) {
            answer[i] = path.get(i);
        }

        return answer;
    }

    private void hanoi(int n, int from, int to) {
        if (n == 1) {
            path.add(new int[] { from, to });
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (i != from && i != to) {
                hanoi(n - 1, from, i);
                hanoi(1, from, to);
                hanoi(n - 1, i, to);
            }
        }
    }
}
