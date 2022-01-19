package Programmers.level1;

import java.util.Arrays;
// import java.util.stream.IntStream;

public class Prob12921 {
    public int solution(int n) {
        boolean[] primeNumber = new boolean[n + 1];

        Arrays.fill(primeNumber, true);
        for (int i = 2; i * i < primeNumber.length; i++) {
            if (primeNumber[i]) {
                for (int j = i * i; j < primeNumber.length; j += i) {
                    primeNumber[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i < primeNumber.length; i++) {
            if (primeNumber[i]) {
                answer++;
            }
        }

        return answer;

        // stream을 쓰면 더 느려짐
        // 실행 속도가 2배정도 차이남 (30ms vs 60ms)
        // return (int) IntStream.range(2, primeNumber.length).filter(i -> primeNumber[i]).count();
    }
}
