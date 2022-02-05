package Programmers.level2;

public class Prob42860 {
    public int solution(String name) {
        boolean[] changed = new boolean[name.length()];
        char[] charArr = name.toCharArray();
        int answer = 0;

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'A') {
                changed[i] = true;
            }

            answer += getMinMove(charArr[i]);
        }

        int cursor = 0;
        while (true) {
            int right = -1;
            int left = -1;

            changed[cursor] = true;

            for (int i = 0; i < charArr.length; i++) {
                if (!changed[getCursor(cursor + i, charArr.length)]) {
                    right = i;
                    break;
                }
            }

            for (int i = 0; i < charArr.length; i++) {
                if (!changed[getCursor(cursor - i, charArr.length)]) {
                    left = i;
                    break;
                }
            }

            if (right != -1 && left != -1) {
                if (right <= left) {
                    answer += right;
                    cursor = getCursor(cursor + right, charArr.length);
                } else {
                    answer += left;
                    cursor = getCursor(cursor - left, charArr.length);
                }
            } else {
                break;
            }
        }

        return answer;
    }

    private int getCursor(int cursor, int length) {
        return cursor < 0 ? length + cursor : cursor % length;
    }

    private int getMinMove(char c) {
        return Math.min(c - 'A', 26 - (c - 'A'));
    }
}
