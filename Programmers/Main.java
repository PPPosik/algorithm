package Programmers;

import Programmers.level2.Prob86052;

public class Main {
    public static void main(String[] args) {
        String[] grid = {"SL","LR"};
        int[] answer = new Prob86052().solution(grid);

        System.out.println("answer : ");
        for(int n: answer) {
            System.out.print(n + " ");
        }
    }
}
