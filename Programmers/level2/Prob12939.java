package Programmers.level2;

public class Prob12939 {
    public String solution(String s) {
        String[] splited = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : splited) {
            int tmp = Integer.parseInt(str);

            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);

        return sb.toString();
    }
}
