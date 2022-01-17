package Programmers.level1;

import java.util.HashMap;

public class Prob42576 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String answer = "";

        for (String name : participant) {
            Integer value = map.get(name);
            if (value != null) {
                map.replace(name, value + 1);
            } else {
                map.put(name, 1);
            }
        }

        for (String name : completion) {
            Integer value = map.get(name);
            if (value != null) {
                map.replace(name, value - 1);
            } else {
                answer = name;
            }
        }

        if (answer.equals("")) {
            for (String name : map.keySet()) {
                if (map.get(name) > 0) {
                    answer = name;
                }
            }
        }

        return answer;
    }
}
