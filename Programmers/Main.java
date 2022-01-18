package Programmers;

import Programmers.level1.Prob12915;

public class Main {
    public static void main(String[] args) {
        String[] strings = { "abce", "abcd", "cdx" };
        String[] answer = new Prob12915().solution(strings, 1);

        for (String str : answer) {
            System.out.println("after : " + str);
        }
    }
}
