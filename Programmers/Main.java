package Programmers;

import Programmers.level2.Prob68936;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[] answer = new Prob68936().solution(grid);

        System.out.print("answer : ");
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
