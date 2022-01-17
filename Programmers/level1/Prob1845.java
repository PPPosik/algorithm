package Programmers.level1;

import java.util.HashMap;

public class Prob1845 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> poke = new HashMap<Integer, Integer>();
        int target = nums.length / 2;
        int answer = 0;

        for (int num : nums) {
            if (poke.get(num) == null) {
                poke.put(num, 1);
            } else {
                poke.put(num, poke.get(num) + 1);
            }
        }

        for (Integer key : poke.keySet()) {
            if (poke.get(key) > 0 && target > 0) {
                poke.put(key, poke.get(key) - 1);
                target--;
                answer++;
            }
        }

        return answer;
    }
}
