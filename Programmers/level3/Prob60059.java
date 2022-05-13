package Programmers.level3;

public class Prob60059 {
    public boolean solution(int[][] key, int[][] lock) {
        int[][] newKey = generateKey(key, lock.length);

        for (int k = 0; k < 4; k++) {
            for (int i = -(newKey.length - 1); i < newKey.length; i++) {
                for (int j = -(newKey.length - 1); j < newKey.length; j++) {
                    int[][] shiftedKey = shift(newKey, i, j);
                    if (unlock(shiftedKey, lock)) {
                        return true;
                    }
                }
            }
            newKey = rotate(newKey);
        }

        return false;
    }

    private int[][] generateKey(int[][] key, int size) {
        int[][] newKey = new int[size][size];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                newKey[i][j] = key[i][j];
            }
        }

        return newKey;
    }

    private int[][] shift(int[][] key, int a, int b) {
        int[][] ret = new int[key.length][key[0].length];

        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret.length; j++) {
                if (0 <= i + a && i + a < ret.length && 0 <= j + b && j + b < ret.length) {
                    ret[i][j] = key[i + a][j + b];
                }
            }
        }

        return ret;
    }

    private boolean unlock(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == key[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] rotate(int[][] key) {
        int[][] ret = new int[key.length][key[0].length];

        for (int j = 0, y = 0; j < key[0].length; j++, y++) {
            for (int i = key.length - 1, x = 0; i >= 0; i--, x++) {
                ret[y][x] = key[i][j];
            }
        }

        return ret;
    }
}
