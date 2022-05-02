package Programmers.level3;

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
            answer += getMoveCnt(r, c, pos[0], pos[1]);

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

    private int getMoveCnt(int beforeY, int beforeX, int afterY, int afterX) {
        int cnt = 1;

        cnt += beforeY == afterY ? 0 : 1;
        cnt += beforeX == afterX ? 0 : 1;

        return cnt;
    }

    private void eraseBoard(int[][] board, int beforeY, int beforeX, int afterY, int afterX) {
        if (board[beforeY][beforeX] != 0 && board[beforeY][beforeX] == board[afterY][afterX]) {
            board[beforeY][beforeX] = 0;
            board[afterY][afterX] = 0;
        }
    }
}
