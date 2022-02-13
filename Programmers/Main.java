package Programmers;

import Programmers.level2.Prob42747;

public class Main {
    public static void main(String[] args) {
        int[] citations = { 0, 0, 0, 0, 1 };
        int answer = new Prob42747().solution(citations);

        System.out.print("answer : " + answer);
    }
}
