package Programmers;

import Programmers.level2.Prob42890;

public class Main {
    public static void main(String[] args) {
        String[][] relation = {
        {"a","1","aaa","c","ng"},
        {"a","1","bbb","e","g"},
        {"c","1","aaa","d","ng"},
        {"d","2","bbb","d","ng"}};
        int answer = new Prob42890().solution(relation);

        System.out.print("answer : " + answer);
    }
}
