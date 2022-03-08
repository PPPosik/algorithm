package Programmers;

import Programmers.level3.Prob81303;

public class Main {
    public static void main(String[] args) {
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        String answer = new Prob81303().solution(8, 2, cmd);

        System.out.print("answer : " + answer);
    }
}
