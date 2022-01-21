package Programmers.level2;

import java.util.ArrayList;

public class Prob42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        int[] remainDays = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            remainDays[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }

        int work = 0;
        int waitingDay = remainDays[0];
        for (int day : remainDays) {
            if (day > waitingDay) {
                answerList.add(work);
                work = 1;
                waitingDay = day;
            } else {
                work++;
            }
        }
        answerList.add(work);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
