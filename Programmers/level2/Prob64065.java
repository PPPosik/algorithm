package Programmers.level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Prob64065 {
    public int[] solution(String s) {
        String[] numbersStr = s.split("[{},]");
        HashMap<Integer, Integer> tuples = new HashMap<Integer, Integer>();

        for (String st : numbersStr) {
            if (st.length() > 0) {
                int num = Integer.parseInt(st);
                tuples.put(num, tuples.get(num) == null ? 1 : tuples.get(num) + 1);
            }
        }

        List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(tuples.entrySet());
        Collections.sort(list, ((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        }));

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}
