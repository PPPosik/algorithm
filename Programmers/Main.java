package Programmers;

import Programmers.level3.Prob72415;

public class Main {
    public static void main(String[] args) {
        int[][] board = { { 1, 2, 2, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        int answer = new Prob72415().solution(board, 0, 0); // 9

        System.out.println("answer : " + answer);
    }
}
