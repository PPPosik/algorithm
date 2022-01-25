package Programmers;

import Programmers.level2.Prob72411;

public class Main {
    public static void main(String[] args) {
        String[] orders = {"ABCD", "BA", "BC"};
        int[] course = {2, 3, 4};
        String[] answer = new Prob72411().solution(orders, course);

        for(String s: answer) {
            System.out.println(s);
        }
    }
}
