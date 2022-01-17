package Programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Prob42840 {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] scores = new int[3];
        int maxScore = -1;
        int[] firstPerson = { 1, 2, 3, 4, 5 };
        int[] secondPerson = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] thirdPerson = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        for (int i = 0; i < answers.length; i++) {
            if (firstPerson[i % firstPerson.length] == answers[i]) {
                scores[0]++;
            }
            if (secondPerson[i % secondPerson.length] == answers[i]) {
                scores[1]++;
            }
            if (thirdPerson[i % thirdPerson.length] == answers[i]) {
                scores[2]++;
            }
        }

        maxScore = Math.max(Math.max(scores[0], scores[1]), scores[2]);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
