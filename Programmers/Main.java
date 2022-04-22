package Programmers;

import Programmers.level3.Prob72413;

public class Main {
    public static void main(String[] args) {
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        int answer = new Prob72413().solution(7, 3, 4, 1, fares);

        System.out.println("answer : " + answer);
    }
}
