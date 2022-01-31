package Programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;

public class Prob86052 {
    final int[] dy = { 0, 1, 0, -1 };
    final int[] dx = { -1, 0, 1, 0 };

    HashSet<PosPair> path;
    char[][] map;

    public int[] solution(String[] grid) {
        path = new HashSet<PosPair>();
        map = new char[grid.length][];

        for (int i = 0; i < map.length; i++) {
            map[i] = grid[i].toCharArray();
        }

        ArrayList<Integer> tmp = new ArrayList<Integer>();

        for (int i = 0; i < dy.length; i++) {
            int moveCnt = move(new Pos(dy[i], dx[i]), new Pos(0, 0), -1);
            System.out.println("----------");
            if (moveCnt > 0) {
                tmp.add(moveCnt);
            }
        }

        for (PosPair pair : path) {
            System.out.println(pair.toString() + " " + pair.hashCode());
        }

        int[] answer = new int[tmp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tmp.get(i);
        }

        return answer;
    }

    private int move(Pos from, Pos to, int depth) {
        if (depth > 10)
            return 0;
        if (!path.add(new PosPair(from, to))) {
            return depth;
        }
        System.out.println(" (" + from.getY() + ", " + from.getX() + ") (" +
                to.getY() + ", " + to.getX() + ") ");

        Pos nextPos = new Pos(to.getY() < 0 ? map.length - 1 : to.getY() % map.length,
                to.getX() < 0 ? map[0].length - 1 : to.getX() % map[0].length);
        if (map[nextPos.getY()][nextPos.getX()] == 'S') {
            nextPos = straight(from, to);
        } else if (map[nextPos.getY()][nextPos.getX()] == 'L') {
            nextPos = left(from, to);
        } else if (map[nextPos.getY()][nextPos.getX()] == 'R') {
            nextPos = right(from, to);
        }

        return move(to, nextPos, depth + 1);
    }

    private Pos straight(Pos from, Pos to) {
        int dy = to.getY() - from.getY();
        int dx = to.getX() - from.getX();

        to.setY(to.getY() < 0 ? map.length - 1 : to.getY() % map.length);
        to.setX(to.getX() < 0 ? map[0].length - 1 : to.getX() % map[0].length);

        return new Pos(to.getY() + dy, to.getX() + dx);
    }

    private Pos left(Pos from, Pos to) {
        int dy = to.getY() - from.getY();
        int dx = to.getX() - from.getX();

        to.setY(to.getY() < 0 ? map.length - 1 : to.getY() % map.length);
        to.setX(to.getX() < 0 ? map[0].length - 1 : to.getX() % map[0].length);

        return new Pos(to.getY() + -1 * dx, to.getX() + dy);
    }

    private Pos right(Pos from, Pos to) {
        int dy = to.getY() - from.getY();
        int dx = to.getX() - from.getX();

        to.setY(to.getY() < 0 ? map.length - 1 : to.getY() % map.length);
        to.setX(to.getX() < 0 ? map[0].length - 1 : to.getX() % map[0].length);

        return new Pos(to.getY() + dx, to.getX() + -1 * dy);
    }

    private class PosPair {
        Pos first;
        Pos second;

        private PosPair(Pos first, Pos second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof PosPair) {
                PosPair tmp = (PosPair) obj;
                // return true;
                return tmp.first.equals(this.first) && tmp.second.equals(this.second);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }

        @Override
        public String toString() {
            return first.toString() + second.toString();
        }
    }

    private class Pos {
        int y;
        int x;

        private Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pos) {
                Pos tmp = (Pos) obj;
                // return true;
                return tmp.getY() == this.getY() && tmp.getX() == this.getX();
            }

            return false;
        }

        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }

        @Override
        public String toString() {
            return y + "" + x;
        }
    }
}
