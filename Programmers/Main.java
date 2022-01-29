package Programmers;

import Programmers.level2.Prob42577;

public class Main {
    public static void main(String[] args) {
        String[] phones = {"123", "456", "789"};
        boolean answer = new Prob42577().solution(phones);

        System.out.print("answer : " + answer);
    }
}
