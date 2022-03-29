package Programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Prob92341 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> times = new HashMap<>();
        Map<String, Integer> pay = new HashMap<>();
        Map<String, String> parking = new HashMap<>();

        for (String s : records) {
            String[] splited = s.split(" ");

            if (splited[2].equals("IN")) {
                parking.put(splited[1], splited[0]);

                if (times.get(splited[1]) == null) {
                    times.put(splited[1], 0);
                }
            } else if (splited[2].equals("OUT")) {
                String inTime = parking.get(splited[1]);
                parking.remove(splited[1]);

                int accumlateTime = times.get(splited[1]);
                accumlateTime += calcTime(inTime, splited[0]);
                times.put(splited[1], accumlateTime);
            }
        }

        for (Entry<String, String> entry : parking.entrySet()) {
            int accumlateTime = times.get(entry.getKey());
            accumlateTime += calcTime(entry.getValue(), "23:59");
            times.put(entry.getKey(), accumlateTime);
        }

        for (Entry<String, Integer> entry : times.entrySet()) {
            int fee = fees[1] + (int) Math.ceil(Math.max(0, entry.getValue() - fees[0]) / (double) fees[2]) * fees[3];
            pay.put(entry.getKey(), fee);
        }

        List<Entry<String, Integer>> list = new ArrayList<>(pay.entrySet());
        Collections.sort(list, ((o1, o2) -> Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey())));

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getValue();
        }

        return answer;
    }

    private int calcTime(String in, String out) {
        String[] splitedOut = out.split(":");
        String[] splitedIn = in.split(":");

        int inTime = Integer.parseInt(splitedIn[0]) * 60 + Integer.parseInt(splitedIn[1]);
        int outTime = Integer.parseInt(splitedOut[0]) * 60 + Integer.parseInt(splitedOut[1]);

        return outTime - inTime;
    }
}
