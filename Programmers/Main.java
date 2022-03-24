package Programmers;

import Programmers.level2.Prob12913;

public class Main {
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6 , 7 ,8}, {4, 3, 2, 1}};
        int answer = new Prob12913().solution(land);

        System.out.print("answer : " + answer);
    }
}
