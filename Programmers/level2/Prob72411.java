package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob72411 {
    HashMap<String, Integer> combinationResult;
    HashMap<Integer, Integer> bestCombination;
    ArrayList<String> result;

    public String[] solution(String[] orders, int[] course) {
        combinationResult = new HashMap<String, Integer>();
        bestCombination = new HashMap<Integer, Integer>();
        result = new ArrayList<String>();

        for (String order : orders) {
            char[] charArr = order.toCharArray();
            boolean[] visited = new boolean[charArr.length];

            Arrays.sort(charArr);

            for (int r : course) {
                if (charArr.length >= r) {
                    combination(charArr, visited, r, 0);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : combinationResult.entrySet()) {
            int length = entry.getKey().length();
            if (entry.getValue() >= 2
                    && (bestCombination.get(length) == null || bestCombination.get(length) < entry.getValue())) {
                bestCombination.put(length, entry.getValue());
            }
        }

        for (Map.Entry<Integer, Integer> bestEntry : bestCombination.entrySet()) {
            for (Map.Entry<String, Integer> entry : combinationResult.entrySet()) {
                if (entry.getKey().length() == bestEntry.getKey() && entry.getValue() == bestEntry.getValue()) {
                    result.add(entry.getKey());
                }
            }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    public void combination(char[] charArr, boolean[] visited, int r, int idx) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < charArr.length; i++) {
                if (visited[i]) {
                    sb.append(charArr[i]);
                }
            }

            combinationResult.put(sb.toString(),
                    (combinationResult.get(sb.toString()) == null ? 0 : combinationResult.get(sb.toString())) + 1);
            return;
        } else if (idx >= charArr.length) {
            return;
        }

        visited[idx] = true;
        combination(charArr, visited, r - 1, idx + 1);

        visited[idx] = false;
        combination(charArr, visited, r, idx + 1);
    }
}
