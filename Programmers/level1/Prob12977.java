package Programmers.level1;

import java.util.Arrays;

public class Prob12977 {
    public int solution(int[] nums) {
        boolean[] primeNumbers = new boolean[3000];
        boolean[] visited = new boolean[nums.length];

        Arrays.fill(primeNumbers, true);
        Arrays.fill(visited, false);
        for (int i = 2; i * i < primeNumbers.length; i++) {
            if (primeNumbers[i]) {
                for (int j = i * i; j < primeNumbers.length; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        return combination(primeNumbers, nums, visited, 0, 3);
    }

    public int combination(boolean[] primeNumbers, int[] numbers, boolean[] visited, int idx, int r) {
        if (r == 0) {
            int target = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    target += numbers[i];
                }
            }

            if (checkPrime(primeNumbers, target)) {
                return 1;
            } else {
                return 0;
            }
        } else if (idx == numbers.length) {
            return 0;
        }

        int answer = 0;

        visited[idx] = true;
        answer += combination(primeNumbers, numbers, visited, idx + 1, r - 1);

        visited[idx] = false;
        answer += combination(primeNumbers, numbers, visited, idx + 1, r);

        return answer;
    }

    public boolean checkPrime(boolean[] primeNumbers, int target) {
        if (target < primeNumbers.length && primeNumbers[target]) {
            return true;
        } else {
            return false;
        }
    }
}
