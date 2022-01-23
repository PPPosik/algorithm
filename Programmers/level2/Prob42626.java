package Programmers.level2;

import java.util.Arrays;

public class Prob42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        long[] scovilleLong = new long[scoville.length];
        for (int i = 0; i < scovilleLong.length; i++) {
            scovilleLong[i] = scoville[i];
        }

        for (int i = 0; i < scovilleLong.length - 1; i++) {
            Arrays.sort(scovilleLong);
            if (scovilleLong[i] >= K) {
                break;
            }

            scovilleLong[i + 1] = 2 * scovilleLong[i + 1] + scovilleLong[i];
            answer++;
        }

        if (scovilleLong[scovilleLong.length - 1] < K) {
            answer = -1;
        }

        return answer;
    }
}
