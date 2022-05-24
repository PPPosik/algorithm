package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[] answer = new Prob12938().solution(2, 9);

        System.out.print("answer : ");
        for(int n : answer) {
            System.out.print(n + " ");
        }
    }
}
