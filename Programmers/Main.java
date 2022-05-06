package Programmers;

import Programmers.level3.Prob92343;

public class Main {
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 0, 0};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}, {2, 6}, {2, 7}};
        int answer = new Prob92343().solution(info, edges);

        System.out.println("answer : " + answer);
    }
}
