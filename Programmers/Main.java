package Programmers;

import Programmers.level2.Prob87377;

public class Main {
    public static void main(String[] args) {
        int[][] line = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };
        String[] answer = new Prob87377().solution(line);

        System.out.println("answer : ");
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
