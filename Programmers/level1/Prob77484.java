package Programmers.level1;

public class Prob77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = { 0, 0 };
        int rank = 7;
        int unknown = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                unknown++;
                continue;
            }

            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    rank--;
                }
            }
        }

        answer[0] = rank - unknown < 1 ? 1 : rank - unknown;
        answer[0] = answer[0] > 6 ? 6 : answer[0];
        answer[1] = rank > 6 ? 6 : rank;

        return answer;
    }
}
