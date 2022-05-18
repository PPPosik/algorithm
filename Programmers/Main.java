package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = new Prob42579().solution(genres, plays);

        System.out.print("answer : ");
        for(int s : answer) {
            System.out.print(s + " ");
        }
    }
}
