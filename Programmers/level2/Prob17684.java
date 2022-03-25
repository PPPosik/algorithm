package Programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Prob17684 {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();

        list.add(" ");
        for (char c = 'A'; c <= 'Z'; c++) {
            list.add(Character.toString(c));
        }

        int idx = 0;
        while (idx < msg.length()) {
            String tmp = "";
            int tmpIdx = -1;

            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);

                if (tmp.length() < s.length() && idx + s.length() <= msg.length()
                        && msg.substring(idx, idx + s.length()).equals(s)) {
                    tmp = s;
                    tmpIdx = i;
                }
            }

            answerList.add(tmpIdx);
            if (idx + tmp.length() < msg.length()) {
                list.add(msg.substring(idx, idx + tmp.length() + 1));
            }
            idx += tmp.length();
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
