package Programmers.level1;

public class Prob12934 {
    public long solution(long n) {
        double sqrtVal = Math.sqrt(n);

        if (n % sqrtVal == 0) {
            return (long) Math.pow(sqrtVal + 1, 2);
        } else {
            return -1;
        }
    }
}
