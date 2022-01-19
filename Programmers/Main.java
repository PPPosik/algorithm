package Programmers;

import Programmers.level1.Prob12932;

public class Main {
    public static void main(String[] args) {
        long n = 10000000000L;
        int[] answer = new Prob12932().solution(n);

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}
