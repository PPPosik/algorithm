package Programmers.level3;

import java.util.Arrays;

public class Prob12927 {
    public long solution(int n, int[] works) {
        int sum = 0;

        Arrays.sort(works);
        for(int work : works) {
            sum += work;
        }

        while(n > 0 && sum > 0) {
            for(int i = works.length - 1; i >= 0; i--) {
                if(i == 0) {
                    works[i]--;
                    n--;
                    sum--;
                } else if(works[i] > works[i-1]) {
                    works[i]--;
                    n--;
                    sum--;

                    break;
                }
            }
        }

        long answer = 0;
        for(int work : works) {
            answer += Math.pow(work, 2);
        }

        return answer;
    }
}
