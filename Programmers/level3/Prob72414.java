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

        int[] views = new int[99 * 60 * 60 + 59 * 60 + 59 + 1];
        int idx = 0, k = 0;
        for (int i = 0; i <= play; i++) {
            if (idx < list.size() && list.get(idx).time == i) {
                if (list.get(idx).status) {
                    views[i] = ++k;
                } else {
                    views[i] = k--;
                }
                idx++;
            } else {
                views[i] = k;
            }

            // if(i % 3600 == 0) System.out.println(secToTime(i) + " " + secToTime((int)views[i]));
        }

        long nowView = 0;
        for (int i = 0; i < adv; i++) {
            nowView += views[i];
            // if(i % 3600 == 0) System.out.println(secToTime(i) + " " + secToTime((int)nowView));
        }

        long maxView = nowView;
        int answerSec = 0;
        for (int i = 1; i <= play - adv; i++) {
            nowView -= views[i - 1];
            nowView += views[i - 1 + adv];

            if (maxView < nowView) {
                maxView = nowView;
                answerSec = i;
            }
            // if(i % 3600 == 0) System.out.println(secToTime(i) + " " + secToTime((int)nowView));
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
