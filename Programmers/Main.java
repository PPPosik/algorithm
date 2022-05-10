package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[][] triangles = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = new Prob43105().solution(triangles);

        System.out.println("answer : " + answer);
    }
}
