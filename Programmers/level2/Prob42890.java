package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Prob42890 {
    ArrayList<boolean[]> uniques;

    public int solution(String[][] relation) {
        uniques = new ArrayList<boolean[]>();
        int answer = 0;

        for (int r = 0; r < relation[0].length; r++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(relation, visited, 0, r);
        }

        boolean[] candidates = new boolean[uniques.size()];
        Arrays.fill(candidates, true);

        for (int i = 0; i < candidates.length; i++) {
            if (!candidates[i]) {
                continue;
            }

            for (int j = i + 1; j < candidates.length; j++) {
                if (isSubset(uniques.get(i), uniques.get(j))) {
                    candidates[j] = false;
                }
            }
        }

        for (boolean isCandidate : candidates) {
            if (isCandidate) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isSubset(boolean[] arr1, boolean[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] && !arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public void dfs(String[][] relation, boolean[] visited, int idx, int r) {
        if (r < 0) {
            HashSet<String> tuples = new HashSet<String>();

            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < relation[i].length; j++) {
                    if (visited[j]) {
                        sb.append(relation[i][j]);
                    }
                }

                if (!tuples.add(sb.toString())) {
                    break;
                }
            }

            if (tuples.size() == relation.length) {
                uniques.add(visited.clone());
            }

            return;
        } else if (idx >= visited.length) {
            return;
        }

        visited[idx] = true;
        dfs(relation, visited, idx + 1, r - 1);

        visited[idx] = false;
        dfs(relation, visited, idx + 1, r);
    }
}
