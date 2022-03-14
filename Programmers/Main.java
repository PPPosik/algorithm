package Programmers;

import Programmers.level2.Prob68645;

public class Main {
    public static void main(String[] args) {
        int[] answer = new Prob68645().solution(4);

        System.out.print("answer : ");
        for (int n : answer) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
