package Programmers;

import Programmers.level2.Prob1835;

public class Main {
    public static void main(String[] args) {
        String[] rules = {"N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2","N~F=0", "R~T>2"};
        int answer = new Prob1835().solution(2, rules);

        System.out.print(answer);
    }
}
