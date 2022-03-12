package Programmers;

import Programmers.level2.Prob87946;

public class Main {
    public static void main(String[] args) {
        int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
        int answer = new Prob87946().solution(80, dungeons);

        System.out.print("answer : " + answer);
    }
}
