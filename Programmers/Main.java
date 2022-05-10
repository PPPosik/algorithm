package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[][] key = {{1, 1}, {0, 0}};
        int[][] lock = {{1, 0}, {1, 1}};

        boolean answer = new Prob60059().solution(key, lock);

        System.out.println("answer : " + answer);
    }
}
