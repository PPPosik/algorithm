package Programmers.level1;

public class Prob72410 {
    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9\\-_.]", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^[.]", "");
        answer = answer.replaceAll("[.]$", "");

        if (answer.isEmpty()) {
            answer = "a";
        }

        answer = answer.substring(0, answer.length() > 15 ? 15 : answer.length());
        answer = answer.replaceAll("[.]$", "");

        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}
