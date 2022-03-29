package Programmers;

import Programmers.level2.Prob92341;

public class Main {
    public static void main(String[] args) {
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        int[] answer = new Prob92341().solution(fees, records);

        System.out.print("answer : ");
        for(int n: answer) {
            System.out.print(n + " ");
        }
    }
}
