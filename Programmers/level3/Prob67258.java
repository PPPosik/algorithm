package Programmers.level3;

import java.util.HashMap;
import java.util.HashSet;

public class Prob67258 {
    public int[] solution(String[] gems) {
        HashSet<String> items = new HashSet<>();
        int[] answer = new int[2];

        for (String gem : gems) {
            items.add(gem);
        }

        int left = items.size();
        int right = gems.length;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(answer, gems, items.size(), mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean isPossible(int[] answer, String[] gems, int itemSize, int length) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (map.get(gems[i]) != null) {
                map.put(gems[i], map.get(gems[i]) + 1);
            } else {
                map.put(gems[i], 1);
            }
        }

        if (map.size() == itemSize) {
            answer[0] = 1;
            answer[1] = length;
            return true;
        }

        for (int i = length; i < gems.length; i++) {
            if (map.get(gems[i]) != null) {
                map.put(gems[i], map.get(gems[i]) + 1);
            } else {
                map.put(gems[i], 1);
            }

            if (map.get(gems[i - length]) == 1) {
                map.remove(gems[i - length]);
            } else {
                map.put(gems[i - length], map.get(gems[i - length]) - 1);
            }

            if (map.size() == itemSize) {
                answer[0] = i - (length - 1) + 1;
                answer[1] = i + 1;
                return true;
            }
        }

        return false;
    }
}
