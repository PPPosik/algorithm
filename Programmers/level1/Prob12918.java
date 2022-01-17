package Programmers.level1;

public class Prob12918 {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
