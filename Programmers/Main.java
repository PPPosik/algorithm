package Programmers;

import Programmers.level2.Prob86052;

public class Main {
    public static void main(String[] args) {
        String[] grid = { "R", "R" };
        int[] answer = new Prob86052().solution(grid);

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
