package Programmers.level1;

public class Prob17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];

        for (int i = 0; i < n; i++) {
            String combinedMap = Integer.toBinaryString(arr1[i] | arr2[i]);
            combinedMap = combinedMap.replace('0', ' ');
            combinedMap = combinedMap.replace('1', '#');

            if (combinedMap.length() < n) {
                StringBuilder blanks = new StringBuilder();
                for (int j = 0; j < n - combinedMap.length(); j++) {
                    blanks.append(" ");
                }
                combinedMap = blanks.toString().concat(combinedMap);
            }

            map[i] = combinedMap;
        }

        return map;
    }
}
