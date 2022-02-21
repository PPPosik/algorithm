package Programmers;

import Programmers.level3.Prob64062;

public class Main {
    public static void main(String[] args) {
        int[] stones = {5, 5, 5};
        int answer = new Prob64062().solution(stones, 3);

        System.out.println("answer : " + answer);
    }
}
