package Programmers;

import Programmers.level3.Prob72414;

public class Main {
    public static void main(String[] args) {
        String[] log = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        String answer = new Prob72414().solution("99:59:59", "25:00:00", log);

        System.out.println("answer : " + answer);
    }
}
