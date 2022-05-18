package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
        int answer = new Prob42884().solution(routes);

        System.out.print("answer : " + answer);
    }
}
