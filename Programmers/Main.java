package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};

        int[] answer = new Prob42628().solution(operations);

        System.out.print("answer : ");
        for(int n : answer) {
            System.out.print(n + " ");
        }
    }
}
