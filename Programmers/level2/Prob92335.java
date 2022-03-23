package Programmers.level2;

public class Prob92335 {
    public int solution(int n, int k) {
        String numberStr = Integer.toString(n, k);
        String[] numbers = numberStr.split("0");
        int answer = 0;

        for (String number : numbers) {
            if (number.length() > 0 && isPrime(Long.parseLong(number))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
