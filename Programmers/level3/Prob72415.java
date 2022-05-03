package Programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prob72415 {
    final int[] dy = { 0, -1, 0, 1 };
    final int[] dx = { 1, 0, -1, 0 };

    public int solution(int[][] board, int r, int c) {
        int answer = board[r][c] != 0 ? 1 : 0;

        while (true) {
            int[] pos = getNextPos(board, r, c);
            if (pos[0] == -1 && pos[1] == -1) {
                break;
            }
            answer += getMoveCnt(board, r, c, pos[0], pos[1]);

            eraseBoard(board, r, c, pos[0], pos[1]);

            r = pos[0];
            c = pos[1];
        }

        return answer;
    }

    private int[] getNextPos(int[][] board, int y, int x) {
        int[] pos = new int[] { -1, -1 };

        if (board[y][x] != 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == board[y][x] && !(y == i && x == j)) {
                        pos[0] = i;
                        pos[1] = j;
                    }
                }
            }
        } else {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[board.length][board[0].length];

            queue.offer(new int[] { y, x });
            visited[y][x] = true;

            while (!queue.isEmpty()) {
                int[] p = queue.poll();

                if (board[p[0]][p[1]] != 0) {
                    pos = p;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int newY = p[0] + dy[i];
                    int newX = p[1] + dx[i];

                    if (0 <= newY && newY < board.length && 0 <= newX && newX < board[0].length
                            && !visited[newY][newX]) {
                        visited[newY][newX] = true;
                        queue.offer(new int[] { newY, newX });
                    }
                }
            }
        }

        return pos;
    }

    private int getMoveCnt(int[][] board, int beforeY, int beforeX, int afterY, int afterX) {
        int cnt = 1;

        int[][] dp = new int[4][4];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dp[beforeY][beforeX] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { beforeY, beforeX });

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if (0 <= newY && newY < 4 && 0 <= newX && newX < 4) {
                    if (dp[newY][newX] > dp[p[0]][p[1]] + 1) {
                        dp[newY][newX] = dp[p[0]][p[1]] + 1;
                        queue.offer(new int[] { newY, newX });
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];

                if (0 <= newY && newY < 4 && 0 <= newX && newX < 4) {
                    while (board[newY][newX] == 0) {
                        if (newY + dy[i] < 0 || newY + dy[i] >= 4 || newX + dx[i] < 0 || newX + dx[i] >= 4) {
                            break;
                        }

                        newY += dy[i];
                        newX += dx[i];
                    }

                    if (dp[newY][newX] > dp[p[0]][p[1]] + 1) {
                        dp[newY][newX] = dp[p[0]][p[1]] + 1;
                        queue.offer(new int[] { newY, newX });
                    }
                }
            }
        }

        cnt += dp[afterY][afterX];

        return cnt;
    }

    private void eraseBoard(int[][] board, int beforeY, int beforeX, int afterY, int afterX) {
        if (board[beforeY][beforeX] != 0 && board[beforeY][beforeX] == board[afterY][afterX]) {
            board[beforeY][beforeX] = 0;
            board[afterY][afterX] = 0;
        }
    }
}
