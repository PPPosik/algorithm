package Programmers.level3;

import java.util.*;

public class Prob43163 {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            if (canChange(words[i], begin)) {
                list.get(0).add(i + 1);
            }

            for (int j = 0; j < words.length; j++) {
                if (canChange(words[i], words[j])) {
                    list.get(i + 1).add(j + 1);
                }
            }
        }

        return dfs(list, visited, 0, words, target, 0);
    }

    private int dfs(ArrayList<ArrayList<Integer>> list, boolean[] visited, int idx, String[] words, String target,
            int depth) {
        if (idx > 0 && words[idx - 1].equals(target)) {
            return depth;
        }

        int ret = 0;
        for (int i = 0; i < list.get(idx).size(); i++) {
            int nextIdx = list.get(idx).get(i);

            if (!visited[nextIdx]) {
                visited[nextIdx] = true;
                ret = dfs(list, visited, nextIdx, words, target, depth + 1);
                visited[nextIdx] = false;
            }
        }

        return ret;
    }

    private boolean canChange(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                cnt++;
            }
        }

        return cnt == 1;
    }
}