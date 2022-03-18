package Programmers;

import Programmers.level2.Prob17683;

public class Main {
    public static void main(String[] args) {
        String[] musicinfos = { "13:00,13:02,HELLO,CDEFGA", "12:00,12:03,HELLO2,CDEFGA" };
        String answer = new Prob17683().solution("CDEFGAC", musicinfos);

        System.out.print("answer : " + answer);
    }
}
