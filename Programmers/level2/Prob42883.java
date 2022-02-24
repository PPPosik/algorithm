package Programmers.level2;

public class Prob42883 {
    public String solution(String number, int k) {
        char[] charArr = number.toCharArray();
        boolean[] erased = new boolean[number.length()];
        StringBuilder answer = new StringBuilder();

        int idx = findNext(charArr, erased, 0);

        while (k-- > 0) {
            erased[idx] = true;

            int leftIdx = Integer.MAX_VALUE;
            for (int i = idx; i >= 0; i--) {
                if (!erased[i]) {
                    leftIdx = i;
                    break;
                }
            }

            int rightIdx = Integer.MAX_VALUE;
            for (int i = idx; i < charArr.length; i++) {
                if (!erased[i]) {
                    rightIdx = i;
                    break;
                }
            }

            int tmp = Math.min(leftIdx, rightIdx);
            idx = findNext(charArr, erased, tmp);
        }

        for (int i = 0; i < charArr.length; i++) {
            if (!erased[i]) {
                answer.append(charArr[i]);
            }
        }

        return answer.toString();
    }

    private int findNext(char[] charArr, boolean[] erased, int idx) {
        for (int i = idx; i < charArr.length - 1; i++) {
            if (erased[i]) {
                continue;
            }

            for (int j = i + 1; j < charArr.length; j++) {
                if (!erased[j]) {
                    if (charArr[i] < charArr[j]) {
                        return i;
                    }
                    break;
                }
            }
        }

        return charArr.length - 1;
    }
}
