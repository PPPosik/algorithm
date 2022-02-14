package Programmers;

import Programmers.level2.Prob42584;

public class Main {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };
        int[] answer = new Prob42584().solution(prices);

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
