package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        int answer = new Prob49189().solution(6, edge);

        System.out.println("answer : " + answer);
    }
}
