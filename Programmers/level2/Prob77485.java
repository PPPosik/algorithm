package Programmers.level2;

public class Prob77485 {
    final int[] dx = {1, 0, -1, 0};
    final int[] dy = {0, 1, 0, -1};
    int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        board = new int[rows+1][columns+1];

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                board[i][j] = (i-1)*columns + j;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    private int rotate(int[] point) {
        int nowY = point[0];
        int nowX = point[1];
        int boardVal = board[nowY][nowX];
        int minVal = board[nowY][nowX];

        for(int i = 0; i < 2;) {
            int movedY = nowY + dy[i];
            int movedX = nowX + dx[i];
            int targetY = point[2];
            int targetX = point[3];

            int tmp = board[movedY][movedX];
            board[movedY][movedX] = boardVal;
            boardVal = tmp;
            minVal = Math.min(minVal, boardVal);

            nowX = movedX;
            nowY = movedY;

            if(movedX == targetX && i == 0) {
                i++;
            }
            else if(movedY == targetY && i == 1) {
                break;
            }
        }

        for(int i = 2; i < 4;) {
            int movedY = nowY + dy[i];
            int movedX = nowX + dx[i];
            int targetY = point[0];
            int targetX = point[1];

            int tmp = board[movedY][movedX];
            board[movedY][movedX] = boardVal;
            boardVal = tmp;
            minVal = Math.min(minVal, boardVal);

            nowX = movedX;
            nowY = movedY;

            if(movedX == targetX && i == 2) {
                i++;
            }
            else if(movedY == targetY && i == 3) {
                break;
            }
        }

        System.out.println("board");
        for(int aa = 1; aa < board.length; aa++) {
            for(int bb = 1; bb < board[aa].length; bb++) {
                System.out.print((board[aa][bb] < 10 ? " " : "") + board[aa][bb] + " ");
            }
            System.out.println();
        }
        System.out.println();

        return minVal;
    }
}
