package Programmers;

import Programmers.level2.Prob92342;

public class Main {
    public static void main(String[] args) {
        int[] info = {0,0,0,0,0,0,0,0,3,4,3};
        int[] answer = new Prob92342().solution(10, info);

        System.out.println("answer : ");
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
