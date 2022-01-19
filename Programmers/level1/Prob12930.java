package Programmers.level1;

public class Prob12930 {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                idx = 0;
                continue;
            }

            if (idx % 2 == 0) {
                charArr[i] = Character.toUpperCase(charArr[i]);
            } else {
                charArr[i] = Character.toLowerCase(charArr[i]);
            }

            idx++;
        }

        return new String(charArr);
    }
}
