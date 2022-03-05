package Programmers;

import Programmers.level2.Prob42583;

public class Main {
    public static void main(String[] args) {
        int[] trucks = {2, 2, 2, 2, 1, 1, 1, 1, 1};
        int answer = new Prob42583().solution(5, 5, trucks); // 19

        System.out.println("answer : " + answer);
    }
}
