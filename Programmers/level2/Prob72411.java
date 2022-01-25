package Programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob72411 {
    HashMap<String, Integer> combinationResult;
    HashMap<Integer, String> bestResult;

    public String[] solution(String[] orders, int[] course) {
        combinationResult = new HashMap<String, Integer>();
        bestResult = new HashMap<Integer, String>();

        for(String order: orders) {
            char[] charArr = order.toCharArray();
            boolean[] visited = new boolean[charArr.length];

            Arrays.sort(charArr);
            
            for(int r: course) {
                if(charArr.length >= r) {
                    combination(charArr, visited, r, 0);
                }
            }
        }

        for(Map.Entry<String, Integer> entry: combinationResult.entrySet()) {
            String best = entry.getKey();

            if(bestResult.get(best.length()) == null || combinationResult.get(bestResult.get(best.length())) < entry.getValue()) {
                bestResult.put(best.length(), best);
            }
        }

        for(Map.Entry<String, Integer> entry: combinationResult.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for(Map.Entry<Integer, String> entry: bestResult.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return new String[0];
    }

    public void combination(char[] charArr, boolean[] visited, int r, int idx) {
        if(r == 0) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < charArr.length; i++) {
                if(visited[i]) {
                    sb.append(charArr[i]);
                }
            }

            combinationResult.put(sb.toString(), (combinationResult.get(sb.toString()) == null ? 0 : combinationResult.get(sb.toString())) + 1);
            return;
        }
        else if(idx >= charArr.length) {
            return;
        }

        visited[idx] = true;
        combination(charArr, visited, r - 1, idx + 1);

        visited[idx] = false;
        combination(charArr, visited, r, idx + 1);
    }
}
