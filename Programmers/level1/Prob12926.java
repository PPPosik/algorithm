package Programmers.level1;

public class Prob12926 {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            char appended = c;
            if ('a' <= c && c <= 'z') {
                int mod = ((c + n) - 'a') % 26;
                appended = (char)('a' + mod);
            }
            else if('A' <= c && c <= 'Z') {
                int mod = ((c + n) - 'A') % 26;
                appended = (char)('A' + mod);
            }

            answer.append(appended);
        }

        return answer.toString();
    }
}
