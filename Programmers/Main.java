package Programmers;

import Programmers.level3.Prob72414;

public class Main {
    public static void main(String[] args) {
        String[] log = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String answer = new Prob72414().solution("02:03:55", "00:14:15", log);

        System.out.println("answer : " + answer);
    }
}
