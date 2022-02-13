package Programmers.level2;

import java.util.Arrays;

public class Prob42747 {
    public int solution(int[] citations) {
        int[] nums = citations.clone();
        int answer = 0;

        Arrays.sort(nums);

        int h = 0;
        while (h <= nums[nums.length - 1]) {
            int cnt = 0;

            for (int n : nums) {
                if (h <= n) {
                    cnt++;
                }
            }

            if (h <= cnt) {
                answer = Math.max(answer, h);
            }
            h++;
        }

        return answer;
    }
}
