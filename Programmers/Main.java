package Programmers;

import Programmers.level2.Prob87390;

public class Main {
    public static void main(String[] args) {
        int[] answer = new Prob87390().solution(4, 7, 14);

        System.out.print("answer : ");
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
