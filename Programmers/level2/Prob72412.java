package Programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Prob72412 {
    public int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        int[] answer = new int[query.length];

        for (String str : info) {
            StringBuilder keySb = new StringBuilder();
            StringBuilder valueSb = new StringBuilder();

            for (char c : str.toCharArray()) {
                if ('0' <= c && c <= '9') {
                    valueSb.append(c);
                } else {
                    keySb.append(c);
                }
            }

            String key = keySb.toString();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.parseInt(valueSb.toString()));
        }

        for (int i = 0; i < query.length; i++) {
            for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
                int targetScore = getTargetScore(query[i]);

                if (isSuitable(query[i], entry.getKey())) {
                    for (Integer n : entry.getValue()) {
                        if (targetScore <= n) {
                            answer[i]++;
                        }
                    }
                }
            }
        }

        return answer;
    }

    private int getTargetScore(String str) {
        String[] splitedStr = str.split(" ");
        return Integer.parseInt(splitedStr[splitedStr.length - 1]);
    }

    private boolean isSuitable(String str, String key) {
        String[] splitedStr = str.split(" ");
        String[] splitedKey = key.split(" ");
        ArrayList<String> conditions = new ArrayList<>();

        for (String s : splitedStr) {
            if (!s.equals("and")) {
                conditions.add(s);
            }
        }

        for (int i = 0; i < splitedKey.length; i++) {
            if (conditions.get(i).equals("-")) {
                continue;
            } else if (!conditions.get(i).equals(splitedKey[i])) {
                return false;
            }
        }

        return true;
    }
}
