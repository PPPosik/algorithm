package Programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Prob49994 {
    public int solution(String dirs) {
        Set<Path> set = new HashSet<>();

        int nowY = 0;
        int nowX = 0;
        for (char c : dirs.toCharArray()) {
            if (c == 'U' && nowY < 5) {
                set.add(new Path(nowY, nowX, nowY + 1, nowX));
                set.add(new Path(nowY + 1, nowX, nowY, nowX));
                nowY++;
            } else if (c == 'D' && nowY > -5) {
                set.add(new Path(nowY, nowX, nowY - 1, nowX));
                set.add(new Path(nowY - 1, nowX, nowY, nowX));
                nowY--;
            } else if (c == 'R' && nowX < 5) {
                set.add(new Path(nowY, nowX, nowY, nowX + 1));
                set.add(new Path(nowY, nowX + 1, nowY, nowX));
                nowX++;
            } else if (c == 'L' && nowX > -5) {
                set.add(new Path(nowY, nowX, nowY, nowX - 1));
                set.add(new Path(nowY, nowX - 1, nowY, nowX));
                nowX--;
            } else {
                continue;
            }
        }

        return set.size() / 2;
    }

    private class Path {
        public int startY;
        public int startX;
        public int endY;
        public int endX;

        public Path(int startY, int startX, int endY, int endX) {
            this.startY = startY;
            this.startX = startX;
            this.endY = endY;
            this.endX = endX;
        }

        @Override
        public int hashCode() {
            String s = new String((startY + 10) + "" + (startX + 10) + "" + (endY + 10) + "" + (endX + 10));
            return Integer.parseInt(s);
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }
    }
}
