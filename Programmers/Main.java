package Programmers;

import Programmers.level2.Prob70129;

public class Main {
    public static void main(String[] args) {
        int[] answer = new Prob70129().solution("110010101001");

        System.out.print("answer : ");
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
