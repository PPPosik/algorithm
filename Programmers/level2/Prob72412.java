package Programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

public class Prob72412 {
    String[][] conditionPools = {
            { "cpp", "java", "python" },
            { "backend", "frontend" },
            { "junior", "senior" },
            { "chicken", "pizza" }
    };

    public int[] solution(String[] info, String[] query) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int[] answer = new int[query.length];

        initMap(map, info);

        for (int i = 0; i < query.length; i++) {
            String key = generateKey(query[i]);
            int score = getScore(query[i]);
            ArrayList<ArrayList<Integer>> values = findValues(map, key, score);

            for (ArrayList<Integer> arr : values) {
                answer[i] += findScoreCnt(arr, score);
            }
        }

        return answer;
    }

    private void initMap(Map<String, ArrayList<Integer>> map, String[] info) {
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

            String key = keySb.substring(0, keySb.length() - 1).toString();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.parseInt(valueSb.toString()));
        }

        sortScore(map);
    }

    private void sortScore(Map<String, ArrayList<Integer>> map) {
        for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
    }

    private String generateKey(String str) {
        String[] splited = str.split(" and ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < splited.length - 1; i++) {
            sb.append(splited[i] + " ");
        }

        sb.append(splited[splited.length - 1].split(" ")[0]);

        return sb.toString();
    }

    private int getScore(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if ('0' <= c && c <= '9') {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    private ArrayList<ArrayList<Integer>> findValues(Map<String, ArrayList<Integer>> map, String key, int score) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<String> tmp = new LinkedList<>();

        tmp.offer(key);
        while (true) {
            String s = tmp.peek();

            if (s.contains("-")) {
                tmp.poll();

                int idx = 0;
                for (char c : s.toCharArray()) {
                    if (c == '-') {
                        break;
                    } else if (c == ' ') {
                        idx++;
                    }
                }

                for (int j = 0; j < conditionPools[idx].length; j++) {
                    tmp.offer(s.replaceFirst("-", conditionPools[idx][j]));
                }
            } else {
                break;
            }
        }

        while (!tmp.isEmpty()) {
            String k = tmp.poll();
            if (map.get(k) != null) {
                ret.add(map.get(k));
            }
        }

        return ret;
    }

    // binary search lower bound
    private int findScoreCnt(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (target <= arr.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (target <= arr.get(left)) {
            return arr.size() - left;
        } else {
            return arr.size() - left - 1;
        }
    }
}
