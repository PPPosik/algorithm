package Programmers.level3;

import java.util.ArrayList;
import java.util.Collections;

public class Prob72414 {
    public String solution(String play_time, String adv_time, String[] logs) {
        ArrayList<Log> list = new ArrayList<>();
        int play = timeToSec(play_time);
        int adv = timeToSec(adv_time);

        for (int i = 0; i < logs.length; i++) {
            String[] splited = logs[i].split("-");
            int startTime = timeToSec(splited[0]);
            int endTime = timeToSec(splited[1]);

            list.add(new Log(startTime, true));
            list.add(new Log(endTime, false));
        }

        Collections.sort(list, (o1, o2) -> o1.time - o2.time);

        int answerSec = 0;
        long maxTotal = 0, nowTotal = 0;
        int startTime = 0, startK = 0, startIdx = 0;
        int endTime = 0, endK = 0, endIdx = 0;
        while (endTime != adv) {
            if (list.get(endIdx).time == endTime) {
                if (list.get(endIdx).status) {
                    endK++;
                } else {
                    endK--;
                }
                endIdx++;
            }
            nowTotal += endK;

            endTime++;
        }

        for (int time = 1; time <= play - adv; time++) {
            if (endIdx < list.size() && list.get(endIdx).time == endTime + time) {
                if (list.get(endIdx).status) {
                    endK++;
                } else {
                    endK--;
                }
                endIdx++;
            }
            nowTotal += endK;

            nowTotal -= startK;
            if (startIdx < list.size() && list.get(startIdx).time == startTime + time) {
                if (list.get(startIdx).status) {
                    startK++;
                } else {
                    startK--;
                }
                startIdx++;
            }

            if (nowTotal > maxTotal) {
                maxTotal = nowTotal;
                answerSec = startTime + time;
            }
        }

        return secToTime(answerSec);
    }

    private int timeToSec(String time) {
        String[] splited = time.split(":");
        return Integer.parseInt(splited[0]) * 60 * 60 + Integer.parseInt(splited[1]) * 60
                + Integer.parseInt(splited[2]);
    }

    private String secToTime(int time) {
        int hour = time / (60 * 60);
        int min = (time - hour * 60 * 60) / 60;
        int sec = time % 60;
        return (hour < 10 ? "0" : "") + hour + ":" + (min < 10 ? "0" : "") + min + ":" + (sec < 10 ? "0" : "") + sec;
    }

    private class Log {
        final int time;
        final boolean status;

        public Log(int time, boolean status) {
            this.time = time;
            this.status = status;
        }
    }
}
