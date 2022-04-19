package Programmers;

import Programmers.level3.Prob17676;

public class Main {
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        int answer = new Prob17676().solution(lines);

        System.out.println("answer : " + answer);
    }
}
