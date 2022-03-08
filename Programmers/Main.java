package Programmers;

import Programmers.level2.Prob17680;

public class Main {
    public static void main(String[] args) {
        String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
        int answer = new Prob17680().solution(3, cities);

        System.out.print("answer : " + answer);
    }
}
