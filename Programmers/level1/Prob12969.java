package Programmers.level1;

import java.util.Scanner;

public class Prob12969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
