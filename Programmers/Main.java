package Programmers;

import Programmers.level3.Prob67259;

public class Main {
    public static void main(String[] args) {
        // int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        // int [][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        int answer = new Prob67259().solution(board);

        System.out.println("answer : " + answer);
    }
}
