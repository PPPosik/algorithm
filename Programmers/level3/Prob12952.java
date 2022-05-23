package Programmers.level3;

import java.util.Arrays;

public class Prob12952 {
    public int solution(int n) {
        int[][] pos = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(pos[i], -1);
        }

        return nQueen(pos, n);
    }

    private int nQueen(int[][] pos, int n) {
        if (n == 0) {
            return 1;
        }

        int ret = 0;
        for (int x = 0; x < pos.length; x++) {
            if (isPossible(pos, n, pos.length - n, x)) {
                pos[pos.length - n][0] = pos.length - n;
                pos[pos.length - n][1] = x;
                ret += nQueen(pos, n - 1);
                pos[pos.length - n][0] = -1;
                pos[pos.length - n][1] = -1;
            }
        }

        return ret;
    }

    private boolean isPossible(int[][] pos, int n, int y, int x) {
        for (int i = 0; i < pos.length - n; i++) {
            if (pos[i][0] == y || pos[i][1] == x || Math.abs(pos[i][0] - y) == Math.abs(pos[i][1] - x)) {
                return false;
            }
        }

        return true;
    }
}
