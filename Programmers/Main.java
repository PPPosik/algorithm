package Programmers;

import Programmers.level2.Prob1844;

public class Main {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        int answer = new Prob1844().solution(maps);

        System.out.print("answer : " + answer);
    }
}
