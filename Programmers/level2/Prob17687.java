package Programmers.level2;

import java.util.ArrayList;

public class Prob17687 {
    public String solution(int n, int t, int m, int p) {
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        int time = 0;

        int num = 0;
        while (list.size() < t * m) {
            for (char c : generateNumber(num, n)) {
                list.add(c);
            }
            num++;
        }

        for (Character c : list) {
            System.out.print(c + " ");
        }

        p--;
        while (time < t * m) {
            if (time % m == p) {
                answer.append(list.get(time));
            }

            time++;
        }

        return answer.toString();
    }

    private char[] generateNumber(int num, int n) {
        return Integer.toString(num, n).toUpperCase().toCharArray();
    }
}
