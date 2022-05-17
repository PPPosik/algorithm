package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        String answer = new Prob17678().solution(1, 1, 5, timetable);

        System.out.print("answer : " + answer);
    }
}
