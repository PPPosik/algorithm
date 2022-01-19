package Programmers.level1;

public class Prob12943 {
    public int solution(int num) {
        int MAX_TRY = 500;
        int answer = 0;
        int tryCnt = 0;
        long longNum = num;

        while (true) {
            if (longNum == 1) {
                break;
            } else if (tryCnt >= MAX_TRY) {
                return -1;
            }
            tryCnt++;

            if (longNum % 2 == 0) {
                longNum /= 2;
            } else {
                longNum = longNum * 3 + 1;
            }
            answer++;
        }

        return answer;
    }
}
