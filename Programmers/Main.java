package Programmers;

import Programmers.level3.*;

public class Main {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] answer = new Prob77486().solution(enroll, referral, seller, amount);

        System.out.print("answer : ");
        for(int n : answer) {
            System.out.print(n + " ");
        }
    }
}
