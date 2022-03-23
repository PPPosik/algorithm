package Programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Prob12981 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int[] answer = new int[2];

        int idx = 0;
        char c = ' ';
        for (int i = 0; i < words.length; i++) {
            if (!set.add(words[i]) || (i > 0 && c != words[i].charAt(0))) {
                idx = i;
                break;
            }
            c = words[i].charAt(words[i].length() - 1);
        }

        answer[0] = idx == 0 ? 0 : idx % n + 1;
        answer[1] = idx == 0 ? 0 : idx / n + 1;
        return answer;
    }
}
