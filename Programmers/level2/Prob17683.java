package Programmers.level2;

public class Prob17683 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        for (String str : musicinfos) {
            String[] info = str.split(",");
            int playTime = getTime(info[0], info[1]);

            if (compareCode(playTime, info[3], m)) {
                if (playTime > maxPlayTime) {
                    answer = info[2];
                    maxPlayTime = playTime;
                }
            }
        }

        return answer;
    }

    private boolean compareCode(int playTime, String c, String target) {
        StringBuilder code = new StringBuilder();

        c = replaceCode(c);
        target = replaceCode(target);

        while (code.length() < playTime) {
            code.append(c);
        }

        System.out.println(code.substring(0, playTime) + " " + target);

        return code.substring(0, playTime).contains(target);
    }

    private String replaceCode(String code) {
        String ret = code;

        ret = ret.replace("C#", "c");
        ret = ret.replace("D#", "d");
        ret = ret.replace("F#", "f");
        ret = ret.replace("G#", "g");
        ret = ret.replace("A#", "a");

        return ret;
    }

    private int getTime(String t1, String t2) {
        String[] start = t1.split(":");
        String[] end = t2.split(":");

        int endHour = Integer.parseInt(end[0]);
        int endMinute = Integer.parseInt(end[1]);
        int startHour = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);

        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    }
}
