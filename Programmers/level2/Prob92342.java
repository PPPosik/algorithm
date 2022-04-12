package Programmers.level2;

public class Prob92342 {
    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];

        return func(n, info, lion, 0);
    }

    private int[] func(int n, int[] apeach, int[] lion, int startIdx) {
        if (n == 0) {
            return lion.clone();
        }

        int[] ret = new int[] { -1 };
        int diffMax = 0;
        for (int i = startIdx; i < 11; i++) {
            if (i == 10) {
                lion[i] = n;

                int diff = calcScoreDiff(apeach, lion);
                if (diff != 0 && (diff > diffMax || (diff == diffMax && hasLowerPoint(ret, lion)))) {
                    ret = lion.clone();
                }

                lion[i] = 0;
            } else if (apeach[i] >= lion[i] && apeach[i] + 1 <= n) {
                lion[i] = apeach[i] + 1;
                int[] tmp = func(n - lion[i], apeach, lion, i);

                if (tmp.length > 1) {
                    int diff = calcScoreDiff(apeach, tmp);
                    if (diff != 0 && (diff > diffMax || (diff == diffMax && hasLowerPoint(ret, tmp)))) {
                        ret = tmp;
                        diffMax = diff;
                    }
                }

                lion[i] = 0;
            }
        }

        return ret;
    }

    private boolean hasLowerPoint(int[] arr1, int[] arr2) {
        if (arr1.length == 1) {
            return true;
        }

        for (int i = 10; i >= 0; i--) {
            if (arr2[i] > arr1[i]) {
                return true;
            } else if (arr2[i] < arr1[i]) {
                return false;
            }
        }

        return false;
    }

    private int calcScoreDiff(int[] apeach, int[] lion) {
        int ret = 0;

        for (int i = 0; i < 11; i++) {
            if (apeach[i] >= lion[i] && apeach[i] != 0) {
                ret -= 10 - i;
            } else if (apeach[i] < lion[i]) {
                ret += 10 - i;
            }
        }

        return ret;
    }
}
