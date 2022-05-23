package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[][] answer = new Prob12946().solution(3);

        System.out.print("answer : ");
        for (int[] ans : answer) {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
