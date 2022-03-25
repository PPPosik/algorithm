package Programmers;

import Programmers.level2.Prob17684;

public class Main {
    public static void main(String[] args) {
        int[] answer = new Prob17684().solution("TOBEORNOTTOBEORTOBEORNOT");

        System.out.print("answer : ");
        for(int n: answer) {
            System.out.print(n + " ");
        }
    }
}
