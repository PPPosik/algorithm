package Programmers.level2;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class Prob17686 {
    public String[] solution(String[] files) {
        Map<String, Integer> map = new HashMap<>();
        String[] heads = new String[files.length];
        int[] numbers = new int[files.length];

        generateOriginIdxMap(files, map);
        generateHeadAndNumber(files, heads, numbers);
        sort(files, map, heads, numbers);

        return files;
    }

    private void generateOriginIdxMap(String[] files, Map<String, Integer> map) {
        for (int i = 0; i < files.length; i++) {
            map.put(files[i], i);
        }
    }

    private void generateHeadAndNumber(String[] files, String[] heads, int[] numbers) {
        for (int i = 0; i < files.length; i++) {
            int idx = 0;

            for (; idx < files[i].length(); idx++) {
                if ('0' <= files[i].charAt(idx) && files[i].charAt(idx) <= '9') {
                    break;
                }
            }
            heads[i] = files[i].substring(0, idx).toLowerCase();

            int numberStartIdx = idx;
            for (; idx < files[i].length(); idx++) {
                if (!('0' <= files[i].charAt(idx) && files[i].charAt(idx) <= '9')) {
                    break;
                }
            }
            numbers[i] = Integer.parseInt(files[i].substring(numberStartIdx, idx));
        }
    }

    private void sort(String[] files, Map<String, Integer> map, String[] heads, int[] numbers) {
        Arrays.sort(files, (o1, o2) -> {
            int idx1 = map.get(o1);
            int idx2 = map.get(o2);

            int result = heads[idx1].compareTo(heads[idx2]);
            if (result == 0) {
                return numbers[idx1] - numbers[idx2];
            } else {
                return result;
            }
        });
    }
}
