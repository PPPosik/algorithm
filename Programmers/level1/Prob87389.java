package Programmers.level1;

public class Prob87389 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i < n; i++) {
            System.out.println((n % i));
            if(n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
