package Programmers;

import Programmers.level3.Prob92344;

public class Main {
    public static void main(String[] args) {
        int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };
        int answer = new Prob92344().solution(board, skill);

        System.out.println("answer : " + answer);
    }
}
