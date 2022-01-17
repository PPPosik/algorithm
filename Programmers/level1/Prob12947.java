package Programmers.level1;

public class Prob12947 {
    public boolean solution(int x) {
        int digitSum = 0;
        int tmpX = x;
        while (tmpX > 0) {
            digitSum += tmpX % 10;
            tmpX /= 10;
        }

        if (x % digitSum == 0) {
            return true;
        } else {
            return false;
        }
    }
}
