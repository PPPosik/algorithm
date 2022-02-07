package Programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Prob42578 {
    HashMap<String, Integer> clothesTypeCnt;
    ArrayList<String> types;

    public int solution(String[][] clothes) {
        int answer = 0;

        clothesTypeCnt = new HashMap<String, Integer>();
        types = new ArrayList<String>();

        for (String[] cloth : clothes) {
            Integer value = clothesTypeCnt.get(cloth[1]);
            clothesTypeCnt.put(cloth[1], value == null ? 1 : value + 1);
        }

        for (Entry<String, Integer> entry : clothesTypeCnt.entrySet()) {
            types.add(entry.getKey());
        }

        for (int depth = 0; depth < types.size(); depth++) {
            boolean[] visited = new boolean[types.size()];
            answer += getCombination(visited, 0, depth);
            System.out.println(depth); // depth == 30 시간초과
        }

        return answer;
    }

    private int getCombination(boolean[] visited, int idx, int depth) {
        if (depth < 0) {
            ArrayList<String> combination = new ArrayList<String>();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    combination.add(types.get(i));
                }
            }

            int ret = 1;
            for (String str : combination) {
                ret *= clothesTypeCnt.get(str) != null ? clothesTypeCnt.get(str) : 1;
            }

            return ret;
        } else if (idx >= visited.length) {
            return 0;
        }

        int ret = 0;

        visited[idx] = true;
        ret += getCombination(visited, idx + 1, depth - 1);

        visited[idx] = false;
        ret += getCombination(visited, idx + 1, depth);

        return ret;
    }
}
