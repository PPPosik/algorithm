package Programmers;

import Programmers.level3.Prob67258;

public class Main {
    public static void main(String[] args) {
        String[] str = {"A","B","B","C","B","A"};
        int[] answer = new Prob67258().solution(str);

        System.out.println("answer : " + answer[0] + " " + answer[1]);
    }
}
