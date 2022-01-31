package Programmers.level2;

import java.util.HashSet;

public class Prob86052 {
    HashSet<PosPair> path;
    char[][] map;

    public int[] solution(String[] grid) {
        path = new HashSet<PosPair>();
        map = new char[grid.length][];

        for(int i = 0; i < map.length; i++) {
            map[i] = grid[i].toCharArray();
        }
        System.out.println(path.add(new PosPair(new Pos(0, -1), new Pos(0, 0))));
        System.out.println(path.add(new PosPair(new Pos(0, -1), new Pos(0, 0))));
        // System.out.println(move(new Pos(0, -1), new Pos(0, 0), 0));
        // System.out.println(move(new Pos(1, 0), new Pos(0, 0), 0));
        // System.out.println(move(new Pos(0, 1), new Pos(0, 0), 0));
        // System.out.println(move(new Pos(-1, 0), new Pos(0, 0), 0));

        return new int[3];
    }

    private int move(Pos from, Pos to, int depth) {
        if(!path.add(new PosPair(from, to))) {
            return 0;
        }
        else if(depth != 0 && to.getY() == 0 && to.getX() == 0) {
            return depth;
        }

        Pos nextPos = null;
        if(map[to.getY()][to.getX()] == 'S') {
            nextPos = straight(from, to);
        }
        else if(map[to.getY()][to.getX()] == 'L') {
            nextPos = left(from, to);
        }
        else if(map[to.getY()][to.getX()] == 'R') {
            nextPos = right(from, to);
        }

        int ret = -1;
        if(nextPos != null) {
            ret = move(to, nextPos, depth + 1);
        }

        return ret;
    }

    private Pos straight(Pos from, Pos to) {
        int dy = to.getY() - from.getY();
        int dx = to.getX() - from.getX();
        int newY = (to.getY() + dy) % map.length;
        int newX = (to.getX() + dx) % map[0].length;

        return new Pos(newY < 0 ? map.length : newY, newX < 0 ? map[0].length : newX);
    }

    private Pos left(Pos from, Pos to) {
        int dy = to.getY() - from.getY();
        int dx = to.getX() - from.getX();
        int newY = (to.getY() + -1 * dx) % map.length;
        int newX = (to.getX() + dy) % map[0].length;
        
        return new Pos(newY < 0 ? map.length : newY, newX < 0 ? map[0].length : newX);
    }
    
    private Pos right(Pos from, Pos to) {
        int dy = to.getY() - from.getY();
        int dx = to.getX() - from.getX();
        int newY = (to.getY() + dx) % map.length;
        int newX = (to.getX() + -1 * dy) % map[0].length;
        
        return new Pos(newY < 0 ? map.length : newY, newX < 0 ? map[0].length : newX);
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
            if(obj instanceof PosPair) {
                // 바꿔야함
                return this.toString().equals(obj.toString());
            }
            else {
                return false;
            }
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

        @Override
        public String toString() {
            return y + "" + x;
        }
    }
}
