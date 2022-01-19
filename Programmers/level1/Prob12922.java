package Programmers.level1;

public class Prob12922 {
    public String solution(int n) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            str.append(i % 2 == 0 ? '수' : '박');
        }

        return str.toString();
    }
}
