package Programmers.level3;

import java.util.Arrays;

public class Prob17678 {
    private final String START_TIME = "09:00";

    public String solution(int n, int t, int m, String[] timetable) {
        int[] waiting = new int[timetable.length];
        int[] bus = new int[n];
        int answer = 0;

        for (int i = 0; i < timetable.length; i++) {
            waiting[i] = timeStringToInt(timetable[i]);
        }
        Arrays.sort(waiting);

        bus[0] = timeStringToInt(START_TIME);
        for (int i = 1; i < bus.length; i++) {
            bus[i] = bus[i - 1] + t;
        }

        for (int time = Math.min(waiting[0] - 1, bus[0]); time <= bus[bus.length - 1]; time++) {
            if (canRide(bus, m, waiting, time)) {
                answer = time;
            }
        }

        return timeIntToString(answer);
    }

    private boolean canRide(int[] bus, int m, int[] waiting, int time) {
        int idx = 0;
        for (int i = 0; i < bus.length; i++) {
            int member = 0;
            while (idx < waiting.length && waiting[idx] <= bus[i] && member < m) {
                if (time <= bus[i] && time < waiting[idx]) {
                    return true;
                } else {
                    idx++;
                }

                member++;
            }

            if (member < m && time <= bus[i]) {
                return true;
            }
        }

        return false;
    }

    private int timeStringToInt(String time) {
        String[] splited = time.split(":");
        return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
    }

    private String timeIntToString(int time) {
        String hour = Integer.toString(time / 60);
        String minute = Integer.toString(time % 60);

        if (hour.length() < 2) {
            hour = "0" + hour;
        }
        if (minute.length() < 2) {
            minute = "0" + minute;
        }

        return hour + ":" + minute;
    }
}
