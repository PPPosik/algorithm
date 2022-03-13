package Programmers;

import Programmers.level2.Prob17679;

public class Main {
    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int answer = new Prob17679().solution(4, 5, board);

        System.out.print("answer : " + answer);
    }
}
