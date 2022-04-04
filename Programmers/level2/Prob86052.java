package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Prob86052 {
    final int[] dx = { 1, 0, -1, 0 };
    final int[] dy = { 0, 1, 0, -1 };

    public int[] solution(String[] grid) {
        char[][] nodes = new char[grid.length][];
        Set<PosPair> path = new LinkedHashSet<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = grid[i].toCharArray();
        }

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                int[] result = addPath(nodes, path, i, j);

                for (int n : result) {
                    if (n > 0) {
                        answerList.add(n);
                    }
                }
            }
        }

        for (PosPair p : path) {
        System.out.println("(" + p.fromY + ", " + p.fromX + ") (" + p.toY + ", " + p.toX + ")");
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    private int[] addPath(char[][] nodes, Set<PosPair> path, int fromY, int fromX) {
        int[] ret = new int[4];
        int[] fromPos = new int[2];
        int[] toPos = new int[2];

        for (int i = 0; i < 4; i++) {
            fromPos[0] = fromY;
            fromPos[1] = fromX;
            toPos = movePos(nodes, fromY, fromX, fromY - dy[i], fromX - dx[i]);

            int retVal = 0;
            boolean isSamePath = false;
            while (path.add(new PosPair(fromPos[0], fromPos[1], toPos[0], toPos[1]))) {
                if (!isSamePath) {
                    retVal++;
                }

                if (0 <= toPos[0] && toPos[0] < nodes.length && 0 <= toPos[1] && toPos[1] < nodes[0].length) {
                    int[] tmp = movePos(nodes, toPos[0], toPos[1], fromPos[0], fromPos[1]);
                    fromPos = toPos;
                    toPos = tmp;

                    isSamePath = false;
                } else {
                    int tmpY = toPos[0] - fromPos[0];
                    int tmpX = toPos[1] - fromPos[1];

                    toPos[0] = toPos[0] < 0 ? nodes.length - 1 : toPos[0] % nodes.length;
                    toPos[1] = toPos[1] < 0 ? nodes[0].length - 1 : toPos[1] % nodes[0].length;
                    fromPos[0] = toPos[0] - tmpY;
                    fromPos[1] = toPos[1] - tmpX;

                    isSamePath = true;
                }
            }
            ret[i] = retVal;
        }

        return ret;
    }

    private int[] movePos(char[][] nodes, int fromY, int fromX, int beforeY, int beforeX) {
        int[] toPos = new int[2];

        if (nodes[fromY][fromX] == 'S') {
            toPos = moveS(beforeY, beforeX, fromY, fromX);
        } else if (nodes[fromY][fromX] == 'L') {
            toPos = moveL(beforeY, beforeX, fromY, fromX);
        } else if (nodes[fromY][fromX] == 'R') {
            toPos = moveR(beforeY, beforeX, fromY, fromX);
        }

        return toPos;
    }

    private int[] moveS(int beforeY, int beforeX, int fromY, int fromX) {
        int dy = fromY - beforeY;
        int dx = fromX - beforeX;

        return new int[] { fromY + dy, fromX + dx };
    }

    private int[] moveR(int beforeY, int beforeX, int fromY, int fromX) {
        int dy = fromY - beforeY;
        int dx = fromX - beforeX;

        return new int[] { fromY + dx, fromX - dy };
    }

    private int[] moveL(int beforeY, int beforeX, int fromY, int fromX) {
        int dy = fromY - beforeY;
        int dx = fromX - beforeX;

        return new int[] { fromY - dx, fromX + dy };
    }

    private class PosPair {
        int fromY, fromX;
        int toY, toX;

        public PosPair(int fromY, int fromX, int toY, int toX) {
            this.fromY = fromY;
            this.fromX = fromX;
            this.toY = toY;
            this.toX = toX;
        }

        @Override
        public String toString() {
            return "" + fromY + fromX + toY + toX;
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof PosPair) {
                PosPair tmp = (PosPair) obj;

                return hashCode() == tmp.hashCode();
            } else {
                return false;
            }
        }
    }
}
