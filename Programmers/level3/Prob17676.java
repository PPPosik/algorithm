package Programmers.level3;

import java.util.ArrayList;
import java.util.Collections;

public class Prob17676 {
    final long SECOND = 1000;

    public int solution(String[] lines) {
        ArrayList<Task> times = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String[] splited = lines[i].split(" ");
            long processTime = getProcessTime(splited[2]);
            long endTime = getEndTime(splited[1]);
            long startTime = getStartTime(endTime, processTime);

            times.add(new Task(i, startTime, endTime));
        }

        Collections.sort(times, (o1, o2) -> (int) (o1.startTime - o2.startTime));

        int answer = 0;
        for (int i = 0; i < times.size(); i++) {
            answer = Math.max(answer, getCnt(times, i));
        }

        return answer;
    }

    private int getCnt(ArrayList<Task> times, int idx) {
        long time = idx > 0 ? Math.max(times.get(idx - 1).endTime, times.get(idx).startTime) : times.get(idx).startTime;
        int ret = 0;

        while (time <= times.get(idx).endTime) {
            int cnt = 0;
            for (Task task : times) {
                if ((task.startTime <= time && time <= task.endTime)
                        || (task.startTime < time + SECOND && time + SECOND <= task.endTime)
                        || (time <= task.startTime && task.endTime < time + SECOND)
                        || (task.startTime <= time && time + SECOND <= task.endTime)) {
                    cnt++;
                }
            }
            ret = Math.max(ret, cnt);
            time += Math.min(1000, times.get(idx).endTime - time == 0 ? 1 : times.get(idx).endTime - time);
        }

        return ret;
    }

    private long getProcessTime(String s) {
        return (long) (Double.parseDouble(s.substring(0, s.length() - 1)) * 1000);
    }

    private long getEndTime(String s) {
        String[] splited = s.split(":");
        long hour = Long.parseLong(splited[0]) * 60 * 60 * 1000;
        long min = Long.parseLong(splited[1]) * 60 * 1000;
        long sec = (long) (Double.parseDouble(splited[2]) * 1000);
        return hour + min + sec;
    }

    private long getStartTime(long endTime, long processTime) {
        return endTime - processTime + 1;
    }

    class Task {
        int id;
        long startTime;
        long endTime;

        public Task(int id, long startTime, long endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}