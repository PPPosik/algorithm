package Programmers;

import Programmers.level3.Prob72415;

public class Main {
    public static void main(String[] args) {
        int[][] board = { { 3, 0, 0, 2 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 2, 0, 0, 3 } };
        int answer = new Prob72415().solution(board, 0, 1);

        System.out.println("answer : " + answer);
    }
}
