package Programmers.level1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prob42899 {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> failure = new HashMap<Integer, Double>();
        int[] failPeopleInStage = new int[N + 2];
        int[] answer = new int[N];

        for (int stage : stages) {
            failPeopleInStage[stage]++;
        }

        double allPeopleInStage = 0;
        for (int i = failPeopleInStage.length - 1; i > 0; i--) {
            allPeopleInStage += failPeopleInStage[i];

            failure.put(i, allPeopleInStage != 0 ? failPeopleInStage[i] / allPeopleInStage : 0);
        }

        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(failure.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (Double.compare(o1.getValue(), o2.getValue()) == 0) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return Double.compare(o2.getValue(), o1.getValue());
                }
            }
        });

        // entryList.sort((o1, o2) -> {
        //     if (Double.compare(o1.getValue(), o2.getValue()) == 0) {
        //         return o1.getKey() - o2.getKey();
        //     } else {
        //         return Double.compare(o2.getValue(), o1.getValue());
        //     }
        // });

        int answerIdx = 0;
        for (Map.Entry<Integer, Double> entry : entryList) {
            if (entry.getKey() <= N) {
                answer[answerIdx++] = entry.getKey();
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        return answer;
    }
}
