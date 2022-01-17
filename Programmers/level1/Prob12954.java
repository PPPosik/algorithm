package Programmers.level1;

import java.util.stream.IntStream;

public class Prob12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        IntStream.range(0, n).forEach(i -> {
            answer[i] = (long) x * (i + 1);
        });

        return answer;
    }
}
