package Programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class Prob12915 {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.copyOf(strings, strings.length);

        Arrays.sort(answer, (Comparator<String>) (s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);

            if(c1 == c2) {
                return s1.compareTo(s2);
            }
            else {
                return c1 - c2;
            }
        });

        return answer;
    }
}
