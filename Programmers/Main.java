package Programmers;

import Programmers.level2.Prob81302;

public class Main {
    public static void main(String[] args) {
        String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOOX", "OXOXO", "PXXXO", "OXXXO", "OOOOO" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
        int[] answer = new Prob81302().solution(places);

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
