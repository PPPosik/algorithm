package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int answer = new Prob49191().solution(5, results);

        System.out.print("answer : " + answer);
    }
}
