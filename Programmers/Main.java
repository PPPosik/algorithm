package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = new Prob43163().solution("hit", "cog", words);

        System.out.print("answer : " + answer);
    }
}
