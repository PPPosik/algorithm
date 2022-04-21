package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob86052 {
    final int[] dy = { 0, 1, 0, -1 };
    final int[] dx = { 1, 0, -1, 0 };

    public int[] solution(String[] grid) {
        boolean[][][] visited = new boolean[grid.length][grid[0].length()][4];
        char[][] map = new char[grid.length][];

        for (int i = 0; i < map.length; i++) {
            map[i] = grid[i].toCharArray();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                for (int k = 0; k < 4; k++) {
                    int value = calc(map, visited, i, j, k);

                    if (value > 0) {
                        list.add(value);
                    }
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    private int calc(char[][] map, boolean[][][] visited, int y, int x, int direction) {
        int depth = 0;

        while (!visited[y][x][direction]) {
            visited[y][x][direction] = true;

            int[] nextPos = getNextPos(map, y, x, direction);
            y = nextPos[0];
            x = nextPos[1];
            direction = nextPos[2];
            depth++;
        }

        return depth;
    }

    private int[] getNextPos(char[][] map, int y, int x, int direction) {
        int[] ret = new int[] { -1, -1, -1 };

        if (map[y][x] == 'S') {
            ret[2] = direction;
            ret[0] = y + dy[ret[2]];
            ret[1] = x + dx[ret[2]];
        } else if (map[y][x] == 'L') {
            ret[2] = (direction + 1) % 4;
            ret[0] = y + dy[ret[2]];
            ret[1] = x + dx[ret[2]];
        } else if (map[y][x] == 'R') {
            ret[2] = (direction + 4 - 1) % 4;
            ret[0] = y + dy[ret[2]];
            ret[1] = x + dx[ret[2]];
        }

        ret[0] = ret[0] < 0 ? map.length - 1 : ret[0] % map.length;
        ret[1] = ret[1] < 0 ? map[0].length - 1 : ret[1] % map[0].length;

        return ret;
    }
}
