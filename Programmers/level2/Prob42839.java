package Programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;

public class Prob42839 {
    ArrayList<String> combinations;
    HashSet<Integer> nums;
    char[] charArr;
    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;

        combinations = new ArrayList<String>();
        nums = new HashSet<Integer>();
        charArr = numbers.toCharArray();

        visited = new boolean[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            getCombinations(0, i);
        }

        for (String str : combinations) {
            visited = new boolean[str.length()];
            getNums(str.toCharArray(), 0, 0, "");
        }

        for (Integer n : nums) {
            if (isPrime(n)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void getNums(char[] arr, int idx, int depth, String str) {
        if (depth >= arr.length) {
            nums.add(Integer.parseInt(str));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getNums(arr, i, depth + 1, str + arr[i]);
                visited[i] = false;
            }
        }
    }

    private void getCombinations(int idx, int r) {
        if (r < 0) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(charArr[i]);
                }
            }

            combinations.add(sb.toString());

            return;
        }
        if (idx >= visited.length) {
            return;
        }

        visited[idx] = true;
        getCombinations(idx + 1, r - 1);

        visited[idx] = false;
        getCombinations(idx + 1, r);
    }
}
