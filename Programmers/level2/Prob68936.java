package Programmers.level2;

public class Prob68936 {
    public int[] solution(int[][] arr) {
        return quadCompression(arr, 0, arr.length, 0, arr[0].length);
    }

    private int[] quadCompression(int[][] arr, int fromI, int toI, int fromJ, int toJ) {
        int[] ret = new int[2];

        if (hasSameValue(arr, fromI, toI, fromJ, toJ)) {
            ret[arr[fromI][fromJ]]++;
        } else {
            int[][] results = new int[4][2];
            int bias = (toI - fromI) / 2;

            results[0] = quadCompression(arr, fromI, fromI + bias, fromJ, fromJ + bias);
            results[1] = quadCompression(arr, fromI, fromI + bias, fromJ + bias, toJ);
            results[2] = quadCompression(arr, fromI + bias, toI, fromJ, fromJ + bias);
            results[3] = quadCompression(arr, fromI + bias, toI, fromJ + bias, toJ);

            for (int[] result : results) {
                ret[0] += result[0];
                ret[1] += result[1];
            }
        }

        return ret;
    }

    private boolean hasSameValue(int[][] arr, int fromI, int toI, int fromJ, int toJ) {
        for (int i = fromI; i < toI; i++) {
            for (int j = fromJ; j < toJ; j++) {
                if (arr[i][j] != arr[fromI][fromJ]) {
                    return false;
                }
            }
        }

        return true;
    }
}
