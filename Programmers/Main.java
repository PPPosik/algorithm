package Programmers;

import Programmers.level2.Prob86971;

public class Main {
    public static void main(String[] args) {
        int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
        int answer = new Prob86971().solution(9, wires);

        System.out.print("answer : " + answer);
    }
}
