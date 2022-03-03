package Programmers;

import Programmers.level2.Prob49993;

public class Main {
    public static void main(String[] args) {
        String[] str = { "BACDE", "CBADF", "AECB", "BDA" };
        int answer = new Prob49993().solution("CBD", str);

        System.out.println("answer : " + answer);
    }
}
