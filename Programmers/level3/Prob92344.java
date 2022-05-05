package Programmers.level3;

public class Prob92344 {
    public int solution(int[][] board, int[][] skill) {
        int[][] map = new int[board.length + 1][board[0].length + 1];

        for (int[] arr : skill) {
            action(map, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
        }

        accumulate(map);
        sum(board, map);

        return getBuilding(board);
    }

    private void sum(int[][] board, int[][] map) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += map[i][j];
            }
        }
    }

    private void accumulate(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] += board[i][j - 1];
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            for (int i = 1; i < board.length; i++) {
                board[i][j] += board[i - 1][j];
            }
        }
    }

    private void action(int[][] board, int type, int r1, int c1, int r2, int c2, int degree) {
        int sign = type == 1 ? -1 : 1;

        board[r1][c1] += sign * degree;
        board[r2 + 1][c1] += -1 * sign * degree;
        board[r1][c2 + 1] += -1 * sign * degree;
        board[r2 + 1][c2 + 1] += sign * degree;
    }

    private int getBuilding(int[][] board) {
        int cnt = 0;

        for (int[] arr : board) {
            for (int n : arr) {
                if (n > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
