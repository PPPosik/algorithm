package Programmers;

import Programmers.level2.Prob12978;

public class Main {
    public static void main(String[] args) {
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int answer = new Prob12978().solution(5, road, 3);

        System.out.print("answer : " + answer);
    }
}
