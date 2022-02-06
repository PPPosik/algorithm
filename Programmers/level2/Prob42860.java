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
        }

        answer = dfs(charArr, changed, 0);

        for (int i = 0; i < charArr.length; i++) {
            answer += getMinMove(charArr[i]);
        }

        return answer;
    }

    private int dfs(char[] charArr, boolean[] changed, int cursor) {
        int ret = 0;
        int right = -1;
        int left = -1;

        changed[cursor] = true;

        for (int i = 0; i < charArr.length; i++) {
            if (!changed[getCursor(cursor + i, charArr.length)]) {
                right = i;
                break;
            }
        }

        if (right != -1) {
            int newCursor = getCursor(cursor + right, charArr.length);
            ret = right + dfs(charArr, changed, newCursor);
            changed[newCursor] = false;
        }

        for (int i = 0; i < charArr.length; i++) {
            if (!changed[getCursor(cursor - i, charArr.length)]) {
                left = i;
                break;
            }
        }

        if (left != -1) {
            int newCursor = getCursor(cursor - left, charArr.length);
            ret = Math.min(ret, left + dfs(charArr, changed, newCursor));
            changed[newCursor] = false;
        }

        return ret;
    }

    private int getCursor(int cursor, int length) {
        return cursor < 0 ? length + cursor : cursor % length;
    }

    private int getMinMove(char c) {
        return Math.min(c - 'A', 26 - (c - 'A'));
    }
}
