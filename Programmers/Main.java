package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[] answer = new Prob43164().solution(tickets);

        System.out.print("answer : ");
        for(String s : answer) {
            System.out.print(s + " ");
        }
    }
}
