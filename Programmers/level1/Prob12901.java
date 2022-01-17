package Programmers.level1;

public class Prob12901 {
    public String solution(int a, int b) {
        String[] dates = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
        int[] days = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int daySum = 0;
        for (int i = 0; i < a; i++) {
            daySum += days[i];
        }
        daySum += b;

        return dates[daySum % 7];
    }
}
