package Programmers.level2;

public class Prob12985 {
    public int solution(int n, int a, int b) {
        int answer = 0;

        int tmpA = a;
        int tmpB = b;
        while (tmpA != tmpB) {
            tmpA = tmpA % 2 == 0 ? tmpA / 2 : (tmpA + 1) / 2;
            tmpB = tmpB % 2 == 0 ? tmpB / 2 : (tmpB + 1) / 2;
            answer++;
        }

        return answer;
    }
}
