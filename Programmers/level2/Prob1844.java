package Programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prob1844 {
    private final int[] dx = { 1, 0, -1, 0 };
    private final int[] dy = { 0, 1, 0, -1 };
    private final int DEFAULT_VALUE = -1;

    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] path = new int[maps.length][maps[0].length];

        for (int[] arr : path) {
            Arrays.fill(arr, DEFAULT_VALUE);
        }

        int[] startPos = { 0, 0 };
        path[startPos[0]][startPos[1]] = 1;
        visited[startPos[0]][startPos[1]] = true;
        queue.offer(startPos);

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int newY = pos[0] + dy[i];
                int newX = pos[1] + dx[i];

                if (0 <= newY && newY < maps.length && 0 <= newX && newX < maps[0].length) {
                    if (maps[newY][newX] == 1 && !visited[newY][newX]) {
                        if (path[newY][newX] == DEFAULT_VALUE || path[pos[0]][pos[1]] + 1 < path[newY][newX]) {
                            int[] tmp = { newY, newX };

                            path[newY][newX] = path[pos[0]][pos[1]] + 1;
                            visited[newY][newX] = true;
                            queue.offer(tmp);
                        }
                    }
                }
            }
        }

        for (int[] aa : path) {
            for (int a : aa) {
                if (a < 0 || a > 9) {
                    System.out.print(a + " ");
                } else {
                    System.out.print(" " + a + " ");
                }
            }
            System.out.println();
        }

        return path[path.length - 1][path[0].length - 1];
    }
}
