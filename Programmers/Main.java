package Programmers;

import Programmers.level2.Prob17686;

public class Main {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] answer = new Prob17686().solution(files);

        System.out.print("answer : ");
        for(String str: answer) {
            System.out.print(str + " ");
        }
    }
}
