package Programmers.level1;

import java.util.ArrayList;

public class Prob68935 {
    public int solution(int n) {
        ArrayList<Integer> reverse3 = new ArrayList<Integer>();
        int answer = 0;

        while (n > 0) {
            reverse3.add(n % 3);
            n /= 3;
        }

        int multiple = 1;
        for (int i = reverse3.size() - 1; i >= 0; i--) {
            answer += multiple * reverse3.get(i);
            multiple *= 3;
        }

        return answer;
    }
}
