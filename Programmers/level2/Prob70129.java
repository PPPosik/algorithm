package Programmers.level2;

public class Prob70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int level = 0;
        int deletedZero = 0;

        while (!s.equals("1")) {
            level++;

            int length = s.length();
            s = s.replace("0", "");
            deletedZero += length - s.length();
            s = Integer.toBinaryString(s.length());
        }

        answer[0] = level;
        answer[1] = deletedZero;

        return answer;
    }
}
