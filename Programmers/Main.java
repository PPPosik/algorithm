package Programmers;

import Programmers.level2.Prob77885;

public class Main {
    public static void main(String[] args) {
        long[] numbers = { 0, 51, 2, 7 };
        long[] answer = new Prob77885().solution(numbers);

        System.out.print("answer : ");
        for (long n : answer) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
