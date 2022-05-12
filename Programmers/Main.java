package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {4, 3}};

        int answer = new Prob42627().solution(jobs);

        System.out.println("answer : " + answer);
    }
}
