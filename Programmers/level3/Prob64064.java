package Programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;

public class Prob64064 {
    HashSet<String> hashset;

    public int solution(String[] user_id, String[] banned_id) {
        ArrayList<HashSet<Integer>> combinations = new ArrayList<>();
        hashset = new HashSet<>();

        for (String banned : banned_id) {
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < user_id.length; i++) {
                if (isBannedId(user_id[i], banned)) {
                    set.add(i);
                }
            }

            combinations.add(set);
        }

        bfs(combinations, new boolean[user_id.length], 0);

        return hashset.size();
    }

    private void bfs(ArrayList<HashSet<Integer>> list, boolean[] visited, int idx) {
        if (idx >= list.size()) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(i);
                }
            }
            hashset.add(sb.toString());

            return;
        }

        for (Integer n : list.get(idx)) {
            if (!visited[n]) {
                visited[n] = true;
                bfs(list, visited, idx + 1);
                visited[n] = false;
            }
        }
    }

    private boolean isBannedId(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        char[] userArr = userId.toCharArray();
        char[] bannedArr = bannedId.toCharArray();

        for (int i = 0; i < bannedArr.length; i++) {
            if (bannedArr[i] == '*') {
                continue;
            }

            if (bannedArr[i] != userArr[i]) {
                return false;
            }
        }

        return true;
    }
}
