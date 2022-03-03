package Programmers;

import Programmers.level2.Prob42885;

public class Main {
    public static void main(String[] args) {
        int[] people = { 70, 50, 80, 50 };
        int answer = new Prob42885().solution(people, 100);

        System.out.println("answer : " + answer);
    }
}
