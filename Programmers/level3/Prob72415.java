package Programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prob72415 {
    final int[] dy = { 0, -1, 0, 1 };
    final int[] dx = { 1, 0, -1, 0 };

    public int solution(int[][] board, int r, int c) {
        int size = getSize(board);
        int[] cardNums = new int[size];
        boolean[] visited = new boolean[size];
        int answer = 0;

        answer += getEnterCnt(board);
        answer += permutation(board, r, c, cardNums, visited, 0);

        return answer;
    }

    private int getEnterCnt(int[][] board) {
        int cnt = 0;

        for (int[] arr : board) {
            for (int n : arr) {
                if (n != 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private int getSize(int[][] board) {
        int size = 0;

        for (int[] arr : board) {
            for (int n : arr) {
                size = Math.max(size, n);
            }
        }

        return size;
    }

    private int permutation(int[][] board, int y, int x, int[] cardNums, boolean[] visited, int depth) {
        if (depth == cardNums.length) {
            return getAnswer(board, y, x, cardNums);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < cardNums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cardNums[depth] = i + 1;
                answer = Math.min(answer, permutation(board, y, x, cardNums, visited, depth + 1));
                visited[i] = false;
            }
        }

        return answer;
    }

    private int getAnswer(int[][] board, int y, int x, int[] cardNums) {
        int[][] map = new int[4][4];
        int[][] dp = new int[cardNums.length + 1][2];
        int[][][] pos = new int[cardNums.length + 1][2][2];
        boolean flag = true;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = board[i][j];
            }
        }

        pos[0][0][0] = y;
        pos[0][0][1] = x;
        pos[0][1][0] = y;
        pos[0][1][1] = x;

        for (int k = 0; k < cardNums.length; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (map[i][j] == cardNums[k]) {
                        if (flag) {
                            pos[k + 1][0][0] = i;
                            pos[k + 1][0][1] = j;
                        } else {
                            pos[k + 1][1][0] = i;
                            pos[k + 1][1][1] = j;
                        }
                        flag = !flag;
                    }
                }
            }
        }

        for (int i = 1; i < pos.length; i++) {
            dp[i][0] = Math.min(
                    dp[i - 1][0] + getMoveCnt(map, pos[i - 1][0], pos[i - 1][1])
                            + getMoveCnt(map, pos[i - 1][1], pos[i][0]),
                    dp[i - 1][1] + getMoveCnt(map, pos[i - 1][1], pos[i - 1][0])
                            + getMoveCnt(map, pos[i - 1][0], pos[i][0]));
            dp[i][1] = Math.min(
                    dp[i - 1][0] + getMoveCnt(map, pos[i - 1][0], pos[i - 1][1])
                            + getMoveCnt(map, pos[i - 1][1], pos[i][1]),
                    dp[i - 1][1] + getMoveCnt(map, pos[i - 1][1], pos[i - 1][0])
                            + getMoveCnt(map, pos[i - 1][0], pos[i][1]));
            eraseBoard(map, cardNums[i - 1]);
        }

        return Math.min(dp[cardNums.length][0] + getMoveCnt(map, pos[cardNums.length][0], pos[cardNums.length][1]),
                dp[cardNums.length][1] + getMoveCnt(map, pos[cardNums.length][1], pos[cardNums.length][0]));
    }

    private int getMoveCnt(int[][] board, int[] pos, int[] targetPos) {
        int cnt = 0;

        int[][] dp = new int[4][4];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dp[pos[0]][pos[1]] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { pos[0], pos[1] });

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

        cnt += dp[targetPos[0]][targetPos[1]];

        return cnt;
    }

    private void eraseBoard(int[][] board, int target) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == target) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
