package Programmers;

import Programmers.level1.Prob17681;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = new Prob17681().solution(5, arr1, arr2);
        
        
        for(String str: answer) {
            System.out.println(str);
        }
    }
}
