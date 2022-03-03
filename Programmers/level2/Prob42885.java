package Programmers.level2;

import java.util.Arrays;

public class Prob42885 {
    public int solution(int[] people, int limit) {
        int[] arr = people.clone();
        int answer = 0;
        int left = 0, right = arr.length - 1;

        Arrays.sort(arr);

        while (left <= right) {
            if (left != right && arr[left] + arr[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }

            answer++;
        }

        return answer;
    }
}
