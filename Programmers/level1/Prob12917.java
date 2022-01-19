package Programmers.level1;

import java.util.Arrays;

public class Prob12917 {
    public String solution(String s) {
        char[] charArr = s.toCharArray();

        Arrays.sort(charArr);

        return new StringBuilder(new String(charArr)).reverse().toString();
    }
}
